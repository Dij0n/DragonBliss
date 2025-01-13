package dijon.dragonBliss;

import dijon.dragonBliss.combat.KillListener;
import dijon.dragonBliss.commands.debug;
import dijon.dragonBliss.commands.info;
import dijon.dragonBliss.commands.shop;
import dijon.dragonBliss.data.players.JoinDataListener;
import dijon.dragonBliss.data.players.PlayerFileManager;
import dijon.dragonBliss.data.teams.TeamFileManager;
import dijon.dragonBliss.data.teams.TeamManager;
import dijon.dragonBliss.pedestal.PedastalManager;
import dijon.dragonBliss.pedestal.SmallTextTranslator;
import dijon.dragonBliss.shop.ShopManager;
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
        PedastalManager.initialize();
        SmallTextTranslator.initialize();
        ShopManager.initialize();

        new JoinDataListener();
        new KillListener();

        this.getCommand("debug").setExecutor(new debug());
        this.getCommand("info").setExecutor(new info());
        this.getCommand("shop").setExecutor(new shop());

        new TestRunnable().runTaskTimer(this, 0, 5);

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
