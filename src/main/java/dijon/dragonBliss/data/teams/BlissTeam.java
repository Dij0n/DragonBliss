package dijon.dragonBliss.data.teams;

import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class BlissTeam {

    String name;
    Set<UUID> players;
    int color;

    public BlissTeam(String name, int color) {
        this.name = name;
        this.players = new HashSet<>();
        this.color = color;
    }

    public BlissTeam(String name, Set<UUID> players, int color) {
        this.name = name;
        this.players = players;
        this.color = color;
    }

    public void addPlayer(UUID uuid){
        players.add(uuid);
    }

    public void removePlayer(UUID uuid){
        players.remove(uuid);
    }

    public String getName() {
        return name;
    }

    public Set<UUID> getPlayers() {
        return players;
    }

    public int getColor() {
        return color;
    }
}
