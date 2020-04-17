package poker_game.evaluation;

import org.junit.Test;

import static org.junit.Assert.*;

public class HandEvaluatorTest {


    @Test
   public void  rangHand(){
        String [] hand1 =new String []{"2c" , "2d" , "3h" ,"Ad" ,"7d"};
        int i = HandEvaluator.rankHand(hand1);
        assertEquals(2 , i);
    }




}