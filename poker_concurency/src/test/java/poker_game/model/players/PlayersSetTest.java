package poker_game.model.players;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.*;


/**
 * TODO 23/04/2020 тесты CRASH скорее всего из за того что объект Player не потокобезопасен ссылка убигает
 *
 *
 */
@Ignore
public class PlayersSetTest {


    private FactoryPlayer factoryPlayer;


    @Before
    public void setup() {
        factoryPlayer = new FactoryPlayer();
    }


    @Test
    public void add() {

        ExecutorService service=Executors.newCachedThreadPool();
        Player player1 = factoryPlayer.createPlayer(1, 1500, "A");
        Player player2 = factoryPlayer.createPlayer(2, 1500, "C");
        Player player3 = factoryPlayer.createPlayer(3, 1500, "B");
        PlayersSet set = new PlayersSet();

        int threadCount = 333;
        List<Future> future = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            future.add(service.submit(() -> {
                        set.add(player3);
                        set.add(player2);
                        set.add(player1);
                    }
            ));
        }
        assertEquals(3, set.getPlayers().size());
        service.shutdown();
    }


    @Test
    public void delete() {

        ExecutorService service=Executors.newCachedThreadPool();
        Player player1 = factoryPlayer.createPlayer(1, 1500, "A");
        Player player2 = factoryPlayer.createPlayer(2, 1500, "C");
        PlayersSet set = new PlayersSet();

        int threadCount = 222;
        set.add(player2);
        set.add(player1);

        List<Future> future = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            future.add(service.submit(() -> {
                        set.delete(player2);
                    }
            ));
        }
        assertEquals(1 , set.getPlayers().size());
        service.shutdown();
    }

    @After
    public void end() {

    }

}