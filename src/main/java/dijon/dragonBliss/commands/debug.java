package dijon.dragonBliss.commands;

import dijon.dragonBliss.data.teams.BlissTeam;
import dijon.dragonBliss.data.teams.TeamManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class debug implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;

        for(BlissTeam team : TeamManager.getTeamList().values()){
            player.sendMessage(team.getName() + " " + TeamManager.getTotalTeamValue(team));
        }

        return true;

    }
}
