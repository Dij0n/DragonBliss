package dijon.dragonBliss;

import dijon.dragonBliss.combat.KillListener;
import dijon.dragonBliss.commands.debug;
import dijon.dragonBliss.commands.info;
import dijon.dragonBliss.data.players.JoinDataListener;
import dijon.dragonBliss.data.players.PlayerData;
import dijon.dragonBliss.data.players.PlayerFileManager;
import dijon.dragonBliss.data.teams.TeamFileManager;
import dijon.dragonBliss.data.teams.TeamManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class DragonBliss extends JavaPlugin {

    public static DragonBliss instance;

    @Override
    public void onEnable() {
        instance = this;

        PlayerFileManager.initialize();
        TeamManager.initialize();
        TeamFileManager.initialize();

        new JoinDataListener();
        new KillListener();

        this.getCommand("debug").setExecutor(new debug());
        this.getCommand("info").setExecutor(new info());

        BukkitRunnable test = new BukkitRunnable() {
            @Override
            public void run() {
                for(Player player : Bukkit.getOnlinePlayers()){

                }
            }
        };

        test.runTaskTimer(this, 0, 5);

    }

    @Override
    public void onDisable() {
        PlayerFileManager.saveData();
        TeamFileManager.saveData();
    }



    //TODO
    //  Pedestal with teams
    //  Shop with items
    //  Special items in shop (Compass, Hearts, etc)
    //  On/Off entering nether for active players
    //  Custom Worldborder for active players



}
