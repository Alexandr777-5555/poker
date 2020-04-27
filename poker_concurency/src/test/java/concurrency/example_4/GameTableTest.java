package concurrency.example_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

public class GameTableTest {


    @Test
    public void addPlayer() {
        ExecutorService service = Executors.newCachedThreadPool();
        int threadCount = 500;
        List<Future> future = new ArrayList<>();
        Table table = new GameTable();
        Player player1 = new Player(500, 1);
        Player player2 = new Player(500, 2);
        Player player3 = new Player(500, 3);

        for (int i = 0; i < threadCount; i++) {
            future.add(service.submit(() -> {
                        table.addPlayer(player1);
                        table.addPlayer(player3);
                        table.addPlayer(player2);
                    }
            ));
        }
        assertEquals(3 , table.getPlayerList().size());
    }

}