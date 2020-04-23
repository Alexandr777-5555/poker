package poker_game.model.players;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

public class PlayersTest {

    private FactoryPlayer factoryPlayer;
    private ExecutorService service;
    @Before
    public void setup() {
        factoryPlayer = new FactoryPlayer();
        service=Executors.newCachedThreadPool();
    }


    // TODO упал метод!!!
    @Test
    public void getPlayers() {

        Player player1 = factoryPlayer.createPlayer(1, 1500, "A");
        Player player2 = factoryPlayer.createPlayer(2, 1500, "C");
        Player player3 = factoryPlayer.createPlayer(3, 1500, "B");
        Players players = new Players();

        int threadCount = 500;
        List<Future> future = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            future.add(service.submit(() -> {
                        players.add(player3);
                        players.add(player2);
                        players.add(player1);
                    }
            ));
        }
        assertEquals(3, players.getList().size());
    }


    @Test
    public void delete() {

        Player player1 = factoryPlayer.createPlayer(1, 1500, "A");
        Player player2 = factoryPlayer.createPlayer(2, 1500, "C");
        Player player3 = factoryPlayer.createPlayer(3, 1500, "B");
        Players players = new Players();

        int threadCount = 100;

        players.add(player3);
        players.add(player2);
        players.add(player1);

        List<Future> future = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            future.add(service.submit(() -> {
                        players.delete(player1);
                    }
            ));
        }

        assertEquals(2 , players.getList().size());
    }

    @After
    public void end() {
        service.shutdown();

    }


}