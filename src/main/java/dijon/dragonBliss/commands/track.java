package dijon.dragonBliss.commands;

import dijon.dragonBliss.data.teams.BlissTeam;
import dijon.dragonBliss.data.teams.TeamManager;
import dijon.dragonBliss.shop.compass.CompassManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class track implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;

        if(strings.length != 1){
            player.sendMessage(Component.text("Incorrect Usage!").color(TextColor.color(0xff0000)));
            return true;
        }

        Player tracked = Bukkit.getPlayer(strings[0]);

        if(tracked == null){
            player.sendMessage(Component.text("This player is not online!").color(TextColor.color(0xff0000)));
            return true;
        }

        CompassManager.addCompass(player, player.getInventory().getItemInMainHand(), tracked);

        return true;
    }
}
