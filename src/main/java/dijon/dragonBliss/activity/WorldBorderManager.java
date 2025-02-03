package dijon.dragonBliss.activity;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldBorder;

public class WorldBorderManager {

    public static final Location initialLoc = new Location(Bukkit.getWorld("world"), -500, 70, 0);

    public static WorldBorder global;
    public static WorldBorder activePlayers;

    public static void initialize(){
        global = Bukkit.createWorldBorder();
        global.setCenter(initialLoc);
        global.setSize(12000);
        activePlayers = Bukkit.createWorldBorder();
        activePlayers.setCenter(initialLoc);
        activePlayers.setSize(12000);
    }


}
