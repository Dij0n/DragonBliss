package dijon.dragonBliss.combat;

import dijon.dragonBliss.DragonBliss;
import dijon.dragonBliss.data.players.PlayerDataManager;
import dijon.dragonBliss.data.teams.TeamManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillListener implements Listener {

    public KillListener() {
        Bukkit.getPluginManager().registerEvents(this, DragonBliss.instance);
    }

    @EventHandler
    public void onKill(PlayerDeathEvent e){

        PlayerDataManager.setActive(e.getPlayer().getUniqueId(), false);

        if(e.getPlayer().getKiller() == null) return;

        Player player = e.getPlayer();
        Player killer = e.getPlayer();

        if(!(PlayerDataManager.isActive(killer.getUniqueId()) && PlayerDataManager.isActive(player.getUniqueId()))) return; //Both have to be active for a transaction
        if(TeamManager.getTeamOfPlayer(player).getPlayers().contains(killer.getUniqueId())) return; //No team-kills


        PlayerDataManager.addBalance(killer.getUniqueId(), PlayerDataManager.getValue(player.getUniqueId()));

        Component c = Component.text("\uD83D\uDDE1" + " You killed " + player.getName() + " and gained ").color(TextColor.color(0xFF3A36)).append(Component.text("$30!").color(TextColor.color(0xffff00)));

        killer.sendMessage(c);
        killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 2F, 1.1F);
    }

    @EventHandler
    public void testKill(EntityDeathEvent e){

        if(e.getEntity().getKiller() == null) return;

        Player killer = e.getEntity().getKiller();

        PlayerDataManager.addBalance(killer.getUniqueId(), 30);

        Component c = Component.text("\uD83D\uDDE1" + " You killed " + e.getEntity().getType().name() + " and gained ").color(TextColor.color(0xFF3A36)).append(Component.text("$30!").color(TextColor.color(0xffff00)));

        killer.sendMessage(c);
        killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 2F, 1.1F);
    }

}
