package concurrency.example_1;

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

        ExecutorService service= Executors.newCachedThreadPool();
        int threadCount=500;

        List<Future> future=new ArrayList<>();

        Players players=new Players();

        Player player1=new Player(1 , "ALEX");
        players.add(player1);

        Player player2=new Player(2, "NATI");


        for (int i = 0; i <threadCount ; i++) {
            future.add(service.submit(()-> {
                        players.add(player2);
                    }
            ));
        }

        assertEquals(2 , players.getList().size());

    }

}