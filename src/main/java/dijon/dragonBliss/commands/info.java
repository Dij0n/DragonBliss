package dijon.dragonBliss.commands;

import dijon.dragonBliss.data.players.PlayerDataManager;
import dijon.dragonBliss.data.teams.TeamManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class info implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        Player player = (Player) commandSender;

        Component c11 = Component.text("ʏᴏᴜ ᴀʀᴇ ᴄᴜʀʀᴇɴᴛʟʏ: ").color(TextColor.color(0xffffff));
        Component c12a = Component.text("ᴀʟɪᴠᴇ").color(TextColor.color(0x00ff00)).decorate(TextDecoration.BOLD);
        Component c12b = Component.text("ᴅᴇᴀᴅ").color(TextColor.color(0xff0000)).decorate(TextDecoration.BOLD);

        Component c1;

        if(PlayerDataManager.isActive(player.getUniqueId())){
            c1 = c11.append(c12a);
        }else{
            c1 = c11.append(c12b);
        }

        Component c21 = Component.text("ʙᴀʟᴀɴᴄᴇ: ").color(TextColor.color(0xffffff));
        Component c22 = Component.text("$" + PlayerDataManager.getBalance(player.getUniqueId())).color(TextColor.color(0xFFFF00));

        Component c2 = c21.append(c22);

        Component c31 = Component.text("ᴛᴇᴀᴍ ʙᴀʟᴀɴᴄᴇ: ").color(TextColor.color(0xffffff));
        Component c32 = Component.text("$" + TeamManager.getTotalTeamValue(TeamManager.getTeamOfPlayer(player))).color(TextColor.color(0xFFFF00));

        Component c3 = c31.append(c32);

        player.sendMessage(c1);
        player.sendMessage(c2);
        player.sendMessage(c3);
        return true;

    }
}
