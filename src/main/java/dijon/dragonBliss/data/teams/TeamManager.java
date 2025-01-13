package dijon.dragonBliss.data.teams;

import dijon.dragonBliss.data.players.PlayerDataManager;
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

    public static List<BlissTeam> getSortedTeamList(){
        if (teamList.isEmpty()) {
            return Collections.emptyList();
        }

        return teamList.values()
                .stream()
                .sorted((team1, team2) -> Integer.compare(getTotalTeamValue(team2), getTotalTeamValue(team1)))
                .collect(Collectors.toList());
    }


}
