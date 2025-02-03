package dijon.dragonBliss.activity;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldBorder;

public class WorldBorderManager {

    public static final Location initialLoc = new Location(Bukkit.getWorld("world"), -708, 70, -436);

    public static WorldBorder global;
    public static WorldBorder activePlayers;

    public static void initialize(){
        global = Bukkit.createWorldBorder();
        global.setCenter(initialLoc);
        global.setSize(10000);
        activePlayers = Bukkit.createWorldBorder();
        activePlayers.setCenter(initialLoc);
        activePlayers.setSize(20);
    }


}
