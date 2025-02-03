package dijon.dragonBliss.commands;

import dijon.dragonBliss.bloodmoon.BloodCompassRunnable;
import dijon.dragonBliss.bloodmoon.BloodMoonHandler;
import dijon.dragonBliss.data.teams.BlissTeam;
import dijon.dragonBliss.data.teams.TeamManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class bloodmoon implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        Player player = (Player) commandSender;

        BloodMoonHandler.bloodMoonActive = !BloodMoonHandler.bloodMoonActive;
        if(BloodMoonHandler.bloodMoonActive){
            BloodMoonHandler.activateBloodMoon();
        }

        if(BloodMoonHandler.bloodMoonActive){
            player.sendMessage(Component.text("The blood moon has begun...").color(TextColor.color(0xff0000)));
        }else{
            player.sendMessage(Component.text("The blood moon has ended...").color(TextColor.color(0xFFFE6E)));
        }


        return true;
    }
}
