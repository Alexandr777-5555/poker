package poker_game.model.players;

import concurrency.annotation.NotThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/***
 *
 * класс не потокобезопасен
 */
@NotThreadSafe
//TODO ПЕРЕДЕЛАТЬ КЛАСС не потокобезопасен!!!
public class Players {



    private  List<Player> list;

    public Players() {
        list= new ArrayList<Player>();
    }

    public synchronized void add(Player player){
        if (!list.contains(player)){
            list.add(player);
        }
    }


    public synchronized void delete(Player player){
          if(list.contains(player)){
              list.remove(player);
          }
    }


    public   List<Player> getList() {
        return list;
    }


}
