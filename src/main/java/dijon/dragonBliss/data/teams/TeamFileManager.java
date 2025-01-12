package dijon.dragonBliss.data.teams;

import dijon.dragonBliss.DragonBliss;
import dijon.dragonBliss.data.players.PlayerData;
import dijon.dragonBliss.data.players.PlayerDataManager;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class TeamFileManager {

    public static File teamDataFile;

    public static void initialize(){

        teamDataFile = new File(DragonBliss.instance.getDataFolder(), "teamdata.yml");

        if (!teamDataFile.exists()) {
            try {
                DragonBliss.instance.getDataFolder().mkdirs();
                teamDataFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        loadData();
    }

    public static void saveData() {
        YamlConfiguration config = new YamlConfiguration();

        HashMap<String, BlissTeam> teamList = TeamManager.getTeamList();

        for (BlissTeam team : teamList.values()){
            Bukkit.getLogger().info("Saving team " + team.getName());

            String name = team.getName();
            Set<UUID> players = team.getPlayers();

            List<String> uuidsInStrings = new ArrayList<>();

            for(UUID uuid : players){
                uuidsInStrings.add(uuid.toString());
            }

            int r = Color.fromRGB(team.getColor()).getRed();
            int g = Color.fromRGB(team.getColor()).getGreen();
            int b = Color.fromRGB(team.getColor()).getBlue();

            config.set(name + ".color.r", r);
            config.set(name + ".color.g", g);
            config.set(name + ".color.b", b);
            config.set(name + ".players", uuidsInStrings);
        }

        try {
            config.save(teamDataFile);
            Bukkit.getLogger().info("Saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadData(){
        YamlConfiguration config = new YamlConfiguration();

        try {
            config.load(teamDataFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        TeamManager.resetTeamData();

        for (String teamName : config.getKeys(false)) {
            Bukkit.getLogger().info("Loading team " + teamName);

            int r = config.getInt(teamName + ".color.r");
            int g = config.getInt(teamName + ".color.g");
            int b = config.getInt(teamName + ".color.b");

            Color color = Color.fromRGB(r, g, b);

            List<String> uuidInStrings = (List<String>) config.getList(teamName + ".players");
            Set<UUID> uuids = new HashSet<>();
            for(String string : uuidInStrings){
                uuids.add(UUID.fromString(string));
            }

            BlissTeam team = new BlissTeam(teamName, uuids, color.asRGB());

            TeamManager.addTeam(team);
        }

    }

}
