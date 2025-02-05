package dijon.dragonBliss.data.players;

import dijon.dragonBliss.data.teams.TeamManager;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class PlayerDataManager {

    public static final HashMap<UUID, PlayerData> masterPlayerData = new HashMap<>();

    public static void addNewPlayer(UUID uuid){
        masterPlayerData.put(uuid, new PlayerData(uuid));
        TeamManager.addPlayer(uuid, "No_Team");
    }

    public static void addReturningPlayer(PlayerData playerData){
        masterPlayerData.put(playerData.getUuid(), playerData);
    }

    public static int getValue(UUID uuid){
        return masterPlayerData.get(uuid).getValue();
    }

    public static int getBalance(UUID uuid){
        return masterPlayerData.get(uuid).getBalance();
    }

    public static void setValue(UUID uuid, int value){
        masterPlayerData.get(uuid).setValue(value);
    }

    public static void setBalance(UUID uuid, int balance){
        masterPlayerData.get(uuid).setBalance(balance);
    }

    public static void addBalance(UUID uuid, int balance){
        masterPlayerData.get(uuid).setBalance(getBalance(uuid) + balance);
    }

    public static boolean isActive(UUID uuid){
        return masterPlayerData.get(uuid).isActive();
    }

    public static void setActive(UUID uuid, boolean active){
        masterPlayerData.get(uuid).setActive(active);
    }

    public static boolean isPlayerLoaded(UUID uuid){
        return masterPlayerData.containsKey(uuid);
    }

    public static HashMap<UUID, PlayerData> getMasterPlayerData(){
        return masterPlayerData;
    }

    public static void resetMasterPlayerData(){
        masterPlayerData.clear();
    }



}
