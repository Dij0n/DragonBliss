package dijon.dragonBliss.commands;

import dijon.dragonBliss.activity.WorldBorderManager;
import dijon.dragonBliss.bloodmoon.BloodMoonHandler;
import dijon.dragonBliss.data.players.PlayerData;
import dijon.dragonBliss.data.players.PlayerDataManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class reseteverything implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        WorldBorderManager.activePlayers.setCenter(WorldBorderManager.initialLoc);
        BloodMoonHandler.bloodMoonActive = false;


        for(PlayerData playerData : PlayerDataManager.masterPlayerData.values()){
            playerData.setActive(true);
            playerData.setBalance(0);
        }

        return false;
    }
}
