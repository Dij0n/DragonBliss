package dijon.dragonBliss.activity;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class NameManager {

    private static Scoreboard scoreboard;

    public static void initialize() {
        scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team redTeam = scoreboard.getTeam("red");
        if (redTeam == null) {
            redTeam = scoreboard.registerNewTeam("red");
            redTeam.color(NamedTextColor.RED);
            redTeam.prefix(Component.text("").color(TextColor.color(0xff0000)));
        }
        Team greenTeam = scoreboard.getTeam("green");
        if (greenTeam == null) {
            greenTeam = scoreboard.registerNewTeam("green");
            greenTeam.color(NamedTextColor.GREEN);
            greenTeam.prefix(Component.text("").color(TextColor.color(0x00ff00)));
        }
    }

    public static void addPlayerToTeam(Player player, String teamName) {
        Team team = scoreboard.getTeam(teamName);
        if (team == null) {
            return;
        }
        removePlayerFromTeams(player);
        team.addPlayer(player);
    }

    private static void removePlayerFromTeams(Player player) {
        for (Team team : scoreboard.getTeams()) {
            if (team.hasEntry(player.getName())) {
                team.removeEntry(player.getName());
            }
        }
    }

}
