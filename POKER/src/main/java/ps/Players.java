package ps;

import java.util.List;

/**
 * список игроков
 */

public class Players {

    private List<Player> players;


    public Players(List<Player> players) {
        this.players = players;
    }


    public List<Player> getPlayers() {
        return players;
    }


    public void delete(Player player) {
        if (players.contains(player)) {
            players.remove(player);
        }

    }


}
