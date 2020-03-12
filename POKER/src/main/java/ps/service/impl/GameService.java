package ps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ps.model.Table;
import ps.service.Game;

@Component
public class GameService implements Game {

    @Autowired
    private Table table;

    @Override
    public void play() {
        table.game();
    }
}
