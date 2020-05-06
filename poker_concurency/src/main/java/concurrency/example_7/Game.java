package concurrency.example_7;

import java.util.concurrent.Callable;

public class Game  implements Callable<Player> {

    private Table table;

    public Game(Table table) {
        this.table = table;
    }

    @Override
    public Player call() throws Exception {
        Player winner = table.game();
        return winner;
    }
}
