package poker_game.model.base;

import org.junit.Test;
import poker_game.model.thinks.Think;
import poker_game.model.thinks.impl.ThinkB;
import poker_game.model.thinks.impl.ThinkC;

import static org.junit.Assert.*;

public class FactoryPlayerTest {

    @Test
    public void createPlayer(){
        Player player=FactoryPlayer.createPlayer(1, 155 , "C");
        assertTrue( player.getThink() instanceof ThinkC);
    }

    @Test (expected = IllegalArgumentException.class)
    public void createPlayerFail(){
        Player player=FactoryPlayer.createPlayer(2 , 133 , "D");
    }


   @Test(expected = IllegalArgumentException.class)
    public void createPlayerFailedIdOrChips(){
        Player player=FactoryPlayer.createPlayer(-1 , -55 , "D");
    }





}