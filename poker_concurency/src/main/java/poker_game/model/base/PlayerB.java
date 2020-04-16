package poker_game.model.base;


import poker_game.model.thinks.Think;



/**
 * PlayerB игрок который думает по схеме B
 */

public class PlayerB extends Player {

    public PlayerB() {
    }

    public PlayerB(int id, int chips, Think think) {
        super(id, chips, think);
    }
}
