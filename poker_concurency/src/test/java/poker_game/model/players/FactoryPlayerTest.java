package poker_game.model.players;

import org.junit.Before;
import org.junit.Test;
import poker_game.model.thinks.impl.ThinkC;

import static org.junit.Assert.*;

public class FactoryPlayerTest {

    private FactoryPlayer factoryPlayer;

    @Before
    public void setup(){
        factoryPlayer=new FactoryPlayer();
    }


    @Test
    public void createPlayer(){
        Player player=factoryPlayer.createPlayer(1, 155 , "C");
        assertTrue( player.getThink() instanceof ThinkC);
    }

    @Test (expected = IllegalArgumentException.class)
    public void createPlayerFail(){
        Player player=factoryPlayer.createPlayer(2 , 133 , "D");
    }


   @Test(expected = IllegalArgumentException.class)
    public void createPlayerFailedIdOrChips(){
       Player player=factoryPlayer.createPlayer(-1 , -55 , "D");
    }





}