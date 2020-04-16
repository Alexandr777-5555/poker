package poker_game.model.thinks.impl;

import org.junit.Test;
import poker_game.model.thinks.Think;

import static org.junit.Assert.*;


/***
 *
 *  тестирование функциональности класса {@link ThinkA}
 */

public class ThinkATest {

    @Test
    public void bet(){
        Think think=new ThinkA();
        int bet = think.bet(12);
        assertEquals(200 , bet);
    }


    @Test(expected = IllegalArgumentException.class)
    public void betFail(){
        Think think=new ThinkA();
        int bet = think.bet(-2);
    }




}