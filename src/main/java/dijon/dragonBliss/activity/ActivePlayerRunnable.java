package dijon.dragonBliss.activity;

import dijon.dragonBliss.data.players.PlayerDataManager;
import dijon.dragonBliss.pedestal.PedestalManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ActivePlayerRunnable extends BukkitRunnable {

    @Override
    public void run() {
        PedestalManager.setPodiumText();
        for(Player player : Bukkit.getOnlinePlayers()){
            if(PlayerDataManager.isActive(player.getUniqueId())){
                NameManager.addPlayerToTeam(player, "green");
                player.setWorldBorder(WorldBorderManager.activePlayers);
            }else{
                NameManager.addPlayerToTeam(player, "red");
                player.setWorldBorder(WorldBorderManager.global);
            }
        }
    }
}
