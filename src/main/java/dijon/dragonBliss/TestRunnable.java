package dijon.dragonBliss;

import dijon.dragonBliss.pedestal.PedastalManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TestRunnable extends BukkitRunnable {
    @Override
    public void run() {
        PedastalManager.setPodiumText();
        for(Player player : Bukkit.getOnlinePlayers()){

        }
    }
}
