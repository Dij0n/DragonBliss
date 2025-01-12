package dijon.dragonBliss.data.players;

import dijon.dragonBliss.DragonBliss;
import dijon.dragonBliss.data.teams.TeamFileManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.Team;

public class JoinDataListener implements Listener {

    public JoinDataListener() {
        Bukkit.getPluginManager().registerEvents(this, DragonBliss.instance);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Bukkit.getLogger().info("Player joined " + event.getPlayer().name());

        if(PlayerDataManager.isPlayerLoaded(event.getPlayer().getUniqueId())) return;

        Bukkit.getLogger().info("Adding new Player");
        PlayerDataManager.addNewPlayer(event.getPlayer().getUniqueId());

        Bukkit.getLogger().info("Saving");
        PlayerFileManager.saveData();
        PlayerFileManager.loadData();
        TeamFileManager.saveData();
        TeamFileManager.loadData();
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        PlayerFileManager.saveData();
        TeamFileManager.saveData();
    }

}
