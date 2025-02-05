package dijon.dragonBliss.pedestal;

import dijon.dragonBliss.data.teams.BlissTeam;
import dijon.dragonBliss.data.teams.TeamManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Display;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TextDisplay;

import java.util.ArrayList;

public class PedestalManager {

    public static TextDisplay podium;
    public static Location podiumLoc = new Location(Bukkit.getWorld("world"), -500, 135, 110);


    public static void setPodiumText(){

        podium = getTextDisplay();

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

    private static TextDisplay getTextDisplay(){
        for(Entity entity : podiumLoc.getNearbyEntities(3, 3, 3)){
            if(entity instanceof TextDisplay textDisplay){
                return textDisplay;
            }
        }
        TextDisplay newOne =  (TextDisplay) podiumLoc.getWorld().spawnEntity(podiumLoc, EntityType.TEXT_DISPLAY);
        newOne.setAlignment(TextDisplay.TextAlignment.LEFT);
        newOne.setBillboard(Display.Billboard.CENTER);
        return newOne;
    }

    private static String removeUnderscores(String string){
        return string.replace("_", " ");
    }

}
