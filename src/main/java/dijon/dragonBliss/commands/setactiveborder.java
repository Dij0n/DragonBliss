package dijon.dragonBliss.commands;

import dijon.dragonBliss.activity.WorldBorderManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class setactiveborder implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        int amount = Integer.parseInt(strings[0]);

        WorldBorderManager.activePlayers.setSize(amount);

        return false;
    }
}
