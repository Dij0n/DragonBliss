package dijon.dragonBliss;

import dijon.dragonBliss.activity.ActivePlayerRunnable;
import dijon.dragonBliss.activity.NameManager;
import dijon.dragonBliss.activity.WorldBorderManager;
import dijon.dragonBliss.bloodmoon.BloodCompassRunnable;
import dijon.dragonBliss.bloodmoon.BloodMoonHandler;
import dijon.dragonBliss.combat.KillListener;
import dijon.dragonBliss.commands.*;
import dijon.dragonBliss.data.players.JoinDataListener;
import dijon.dragonBliss.data.players.PlayerFileManager;
import dijon.dragonBliss.data.teams.TeamFileManager;
import dijon.dragonBliss.data.teams.TeamManager;
import dijon.dragonBliss.pedestal.PedastalManager;
import dijon.dragonBliss.pedestal.SmallTextTranslator;
import dijon.dragonBliss.shop.ShopItems;
import dijon.dragonBliss.shop.ShopListener;
import dijon.dragonBliss.shop.ShopManager;
import dijon.dragonBliss.shop.compass.CompassRunnable;
import org.bukkit.plugin.java.JavaPlugin;

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
        ShopItems.initialize();
        ShopManager.initialize();
        NameManager.initialize();
        WorldBorderManager.initialize();

        new JoinDataListener();
        new KillListener();
        new ShopListener();
        new BloodMoonHandler();

        this.getCommand("debug").setExecutor(new debug());
        this.getCommand("info").setExecutor(new info());
        this.getCommand("shop").setExecutor(new shop());
        this.getCommand("track").setExecutor(new track());
        this.getCommand("bloodmoon").setExecutor(new bloodmoon());
        this.getCommand("finale").setExecutor(new finale());
        this.getCommand("reseteverything").setExecutor(new reseteverything());
        this.getCommand("setactiveborder").setExecutor(new reseteverything());

        new ActivePlayerRunnable().runTaskTimer(this, 0, 5);
        new CompassRunnable().runTaskTimer(this, 0, 20);
        new BloodCompassRunnable().runTaskTimer(this, 0, 20);

    }

    @Override
    public void onDisable() {
        PlayerFileManager.saveData();
        TeamFileManager.saveData();
    }




}
