package concurrency.example_2;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

public class PlayersTest {


    @Test
    public void add() {

        ExecutorService service = Executors.newCachedThreadPool();
        int threadCount = 500;

        List<Future> future = new ArrayList<>();

        // два списка игроков
        Players players = new Players();
        Players players2 = new Players();

        Player player1 = new Player(1, "ALEX");
        players.add(player1);
        Player player2 = new Player(2, "NATI");

        Player player3 = new Player(2, "Maria");


        for (int i = 0; i < threadCount; i++) {
            future.add(service.submit(() -> {
                        players.add(player2);
                        players.getList();
                        players2.add(player3);
                    }
            ));
        }
        assertEquals(2, players.getList().size());
        assertEquals(1 , players2.getList().size());
        service.shutdown();
    }
}

