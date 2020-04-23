package poker_game.model.players;


import java.util.HashSet;
import java.util.Set;

public class PlayersSet {

    private final Set<Player> players = new HashSet<>();

    public synchronized void add(Player player) {
        players.add(player);
    }


    public synchronized void delete(Player player) {
        players.remove(player);
    }


    public synchronized Set<Player> getPlayers() {
        return players;
    }


}
