package poker_game.model.players;

import org.junit.Test;
import poker_game.model.thinks.impl.ThinkC;

import static org.junit.Assert.*;

public class FactoryPlayerTest {


    @Test
    public void createPlayer(){
        FactoryPlayer factoryPlayer=new FactoryPlayer();
        Player player=factoryPlayer.createPlayer(1, 155 , "C");
        assertTrue( player.getThink() instanceof ThinkC);
    }

    @Test (expected = IllegalArgumentException.class)
    public void createPlayerFail(){
        FactoryPlayer factoryPlayer=new FactoryPlayer();

        Player player=factoryPlayer.createPlayer(2 , 133 , "D");
    }


   @Test(expected = IllegalArgumentException.class)

    public void createPlayerFailedIdOrChips(){
       FactoryPlayer factoryPlayer=new FactoryPlayer();

       Player player=factoryPlayer.createPlayer(-1 , -55 , "D");
    }





}