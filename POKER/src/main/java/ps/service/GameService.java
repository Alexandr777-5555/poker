package ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import ps.model.Table;

public class GameService implements Game {

    @Autowired
    private Table table;

    @Override
    public void play() {
        table.game();
    }
}
