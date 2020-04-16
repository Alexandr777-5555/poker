package poker_game.model.base;

import poker_game.model.thinks.Think;


/**
 * PlayerC игрок который думает по схеме С
 */

public class PlayerC extends Player {

    public PlayerC() {
    }

    public PlayerC(int id, int chips, Think think) {
        super(id, chips, think);
    }
}
