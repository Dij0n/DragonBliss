package dijon.dragonBliss.activity;

import dijon.dragonBliss.data.players.PlayerDataManager;
import dijon.dragonBliss.pedestal.PedastalManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ActivePlayerRunnable extends BukkitRunnable {

    @Override
    public void run() {
        PedastalManager.setPodiumText();
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
