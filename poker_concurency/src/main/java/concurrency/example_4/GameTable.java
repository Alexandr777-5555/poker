package concurrency.example_4;

import concurrency.annotation.ThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@ThreadSafe
public class GameTable implements Table {

    private List<Player> playerList;

    public GameTable() {
        playerList= Collections.synchronizedList(new ArrayList<Player>());
    }

    public void addPlayer(Player player){
       synchronized (playerList){
           if(!playerList.contains(player)){
               playerList.add(player);
           }
       }
    }

    @Override
    public Player startGame() {
        return null;
    }


}
