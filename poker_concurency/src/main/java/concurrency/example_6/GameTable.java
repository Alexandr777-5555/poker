package concurrency.example_6;

import concurrency.example_5.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GameTable implements Table {

    private  final Logger log = LoggerFactory.getLogger(this.getClass());

    private final List<Player> list;


    public GameTable(List<Player> list) {
        this.list = list;
    }

    @Override
    public synchronized void addPlayer(Player player) {
        if (!list.contains(player)) {
            list.add(player);
        }
    }

    @Override
    public void print() {
        synchronized (list){
            for (int i = 0; i <list.size() ; i++) {
                log.info("игрок + " + list.get(i).getId());
            }
        }

    }


}
