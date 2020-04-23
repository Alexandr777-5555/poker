package poker_game.model.players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {

    private  List<Player> list;

    public Players() {
        list= Collections.synchronizedList(new ArrayList<Player>());
    }

    public synchronized void add(Player player){
        if (!list.contains(player)){
            list.add(player);
        }
    }


    public   List<Player> getList() {
        return list;
    }


}
