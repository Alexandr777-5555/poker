package concurrency.example_4;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        List<Player> players=new ArrayList<>();

        Player player1=new Player(500 , 1);
        Player player2=new Player(500 , 2);
        Player player3=new Player(500 , 3);


        players.add(player1);
        players.add(player3);
        players.add(player2);


        Table table=new Table(players);
        System.out.println(player1.getChips());

        int threadCount=300;

        for (int i = 0; i < threadCount ; i++) {

        }

       // Thread.sleep(5000);

        System.out.println(player1.getChips());

    }
}
