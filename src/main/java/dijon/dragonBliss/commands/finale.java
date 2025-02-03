package dijon.dragonBliss.commands;

import dijon.dragonBliss.activity.WorldBorderManager;
import dijon.dragonBliss.bloodmoon.BloodMoonHandler;
import dijon.dragonBliss.data.players.PlayerDataManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class finale implements CommandExecutor {

    public static final Location finaleLoc = new Location(Bukkit.getWorld("world"), -728, 70, -436);

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        WorldBorderManager.activePlayers.setCenter(finaleLoc);

        for(Player player : Bukkit.getOnlinePlayers()){
            if(PlayerDataManager.isActive(player.getUniqueId())){

                if(player.hasPotionEffect(PotionEffectType.GLOWING)){
                    player.removePotionEffect(PotionEffectType.GLOWING);
                }else{
                    player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 100000, 0));
                }

            }
        }

        return true;
    }
}
