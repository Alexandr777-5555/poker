package poker_game.model.base;


import poker_game.model.thinks.Think;



/**
 * PlayerA игрок который думает по схеме A
 */
public class PlayerA extends Player {


    public PlayerA() {

    }



    public PlayerA(int id, int chips, Think think) {
        super(id, chips, think);
    }


}
