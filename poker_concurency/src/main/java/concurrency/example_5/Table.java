package concurrency.example_5;

import java.util.List;

public interface Table {


    Player startGame();

    void addPlayer(Player player);

    List<Player> getPlayerList();

}
