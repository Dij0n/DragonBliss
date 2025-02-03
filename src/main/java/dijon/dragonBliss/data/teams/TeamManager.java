package dijon.dragonBliss.data.teams;

import dijon.dragonBliss.data.players.PlayerDataManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;
import java.util.stream.Collectors;

public class TeamManager {

    public static final HashMap<String, BlissTeam> teamList = new HashMap<>();
    public static final BlissTeam noTeam = new BlissTeam("No_Team", 0x000000);

    public static void initialize(){
        teamList.put(noTeam.getName(), noTeam);
    }

    public static BlissTeam getTeamOfPlayer(Player player){
        for(BlissTeam team : teamList.values()){
            if(team.getPlayers().contains(player.getUniqueId())){
                return team;
            }
        }
        return noTeam;
    }

    public static void addTeam(BlissTeam team){
        teamList.put(team.getName(), team);
    }

    public static void addPlayer(Player player, String teamName){
        if(teamList.containsKey(teamName)){
            teamList.get(teamName).addPlayer(player);
        }
    }

    public static void removePlayer(Player player, String teamName){
        if(teamList.containsKey(teamName)){
            teamList.get(teamName).removePlayer(player);
        }
    }

    public static HashMap<String, BlissTeam> getTeamList(){
        return teamList;
    }

    public static void resetTeamData(){
        teamList.clear();
        teamList.put(noTeam.getName(), noTeam);
    }

    public static int getTotalTeamValue(BlissTeam blissTeam){
        int total = 0;
        for(UUID uuid : blissTeam.getPlayers()){
            total += PlayerDataManager.getBalance(uuid);
        }
        return total;
    }

    public static Set<UUID> getActivePlayersOnTeam(BlissTeam blissTeam){
        Set<UUID> players = new HashSet<>();
        for(UUID uuid : blissTeam.getPlayers()){
            if(PlayerDataManager.isActive(uuid)) players.add(uuid);
        }
        return players;
    }

    public static Set<UUID> getActiveOnlinePlayersOnTeam(BlissTeam blissTeam){
        Set<UUID> players = new HashSet<>();
        for(UUID uuid : blissTeam.getPlayers()){
            if(PlayerDataManager.isActive(uuid)){
                Player toAdd = Bukkit.getPlayer(uuid);
                if(toAdd != null){
                    players.add(uuid);
                }
            }
        }
        return players;
    }

    public static List<BlissTeam> getSortedTeamList(){
        if (teamList.isEmpty()) {
            return Collections.emptyList();
        }

        return teamList.values()
                .stream()
                .sorted((team1, team2) -> Integer.compare(getTotalTeamValue(team2), getTotalTeamValue(team1)))
                .collect(Collectors.toList());
    }

    public static void addBalanceEvenlyAcrossTeam(BlissTeam team, int amount){
        int[] points = divideEvenly(amount, getActivePlayersOnTeam(team).size());
        int i = 0;
        for(UUID uuid : getActivePlayersOnTeam(team)){
            PlayerDataManager.addBalance(uuid, points[i]);
            i++;
        }
    }

    private static int[] divideEvenly(int number, int parts) {
        int baseValue = number / parts;
        int remainder = number % parts;
        int[] result = new int[parts];

        Arrays.fill(result, baseValue);

        for (int i = 0; i < remainder; i++) {
            result[i] += 1;
        }

        return result;
    }

    public static void sendMessageToTeam(BlissTeam team, Component c){
        for(UUID uuid : getActivePlayersOnTeam(team)){
            if(Bukkit.getPlayer(uuid) == null) continue;
            Bukkit.getPlayer(uuid).sendMessage(c);
        }
    }


}
