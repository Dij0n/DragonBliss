package dijon.dragonBliss.pedestal;

import dijon.dragonBliss.data.teams.BlissTeam;
import dijon.dragonBliss.data.teams.TeamManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.data.type.PointedDripstone;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TextDisplay;
import org.bukkit.util.BoundingBox;

import java.util.ArrayList;

public class PedastalManager {

    public static TextDisplay podium;
    public static Location podiumLoc = new Location(Bukkit.getWorld("world"), -706, 73, -441);


    public static void initialize(){
        for(TextDisplay textDisplay : podiumLoc.getNearbyEntitiesByType(TextDisplay.class, 1, 1, 1)){
            podium = textDisplay;
            return;
        }
        podium = (TextDisplay) podiumLoc.getWorld().spawnEntity(podiumLoc, EntityType.TEXT_DISPLAY);
        podium.setAlignment(TextDisplay.TextAlignment.LEFT);
    }

    public static void setPodiumText(){
        ArrayList<Component> lines = new ArrayList<>();
        for(BlissTeam team : TeamManager.getSortedTeamList()){
            if(team.getName().equalsIgnoreCase("No_Team")) continue;

            String teamname = SmallTextTranslator.smallText(removeUnderscores(team.getName())+ ":  ");
            String scorestring = SmallTextTranslator.smallText(String.valueOf(TeamManager.getTotalTeamValue(team)));

            Component c1 = Component.text(teamname).color(TextColor.color(team.getColor())).decorate(TextDecoration.BOLD);
            Component c2 = Component.text(scorestring).color(TextColor.color(0xffffff)).decoration(TextDecoration.BOLD, false);
            lines.add(c1.append(c2));
        }
        Component fin = Component.text("");

        for(Component component : lines){
            fin = fin.append(component);
            fin = fin.appendNewline();
        }

        podium.text(fin);
    }

    private static String removeUnderscores(String string){
        return string.replace("_", " ");
    }

}
