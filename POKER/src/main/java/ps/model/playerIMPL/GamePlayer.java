package ps.model.playerIMPL;

import ps.model.Think;
import ps.model.base.Player;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * реализует функциональность игрока за покерным столом
 *
 */
//@Entity
//@Table
public class GamePlayer extends Player {

    public GamePlayer(int id, int chips  )
    {
        super(id, chips );
    }

}

