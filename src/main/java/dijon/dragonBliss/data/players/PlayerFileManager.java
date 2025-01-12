package dijon.dragonBliss.data.players;

import dijon.dragonBliss.DragonBliss;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class PlayerFileManager {

    public static File playerDataFile;

    public static void initialize(){

        playerDataFile = new File(DragonBliss.instance.getDataFolder(), "playerdata.yml");

        if (!playerDataFile.exists()) {
            try {
                DragonBliss.instance.getDataFolder().mkdirs();
                playerDataFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        loadData();
    }

    public static void saveData() {
        YamlConfiguration config = new YamlConfiguration();

        HashMap<UUID, PlayerData> playerData = PlayerDataManager.getMasterPlayerData();

        for (PlayerData save : playerData.values()){
            Bukkit.getLogger().info("Saving player " + save.getUuid());

            String uuid = save.getUuid().toString();
            int value = save.getValue();
            int balance = save.getBalance();
            boolean active = save.isActive();

            config.set(uuid + ".value", value);
            config.set(uuid + ".balance", balance);
            config.set(uuid + ".active", active);
        }

        try {
            config.save(playerDataFile);
            Bukkit.getLogger().info("Saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadData(){
        YamlConfiguration config = new YamlConfiguration();

        try {
            config.load(playerDataFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        PlayerDataManager.resetMasterPlayerData();

        for (String uuid : config.getKeys(false)) {
            Bukkit.getLogger().info("Loading player " + uuid);

            int value = config.getInt(uuid + ".value");
            int balance = config.getInt(uuid + ".balance");
            boolean active = config.getBoolean(uuid + ".active");

            PlayerData save = new PlayerData(UUID.fromString(uuid), value, balance, active);

            PlayerDataManager.addReturningPlayer(save);
        }

    }

}
