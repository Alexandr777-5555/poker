package concurrency.example_4;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
   // TODO класс пока не используется

public class Tables{

    private final List<Player> playerList;

    public Tables(List<Player> playerList) {
        this.playerList = new CopyOnWriteArrayList<>(playerList);
    }

    public Player setChipsPlayer(Player player, int amount) {
        if (!playerList.contains(player)) {
            throw new IllegalArgumentException("invalid player " + player);
        }
        player.setChips(player.getChips() + amount);
        return player;
    }





}
*/