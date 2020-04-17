package poker_game.evaluation;

import org.junit.Test;

import static org.junit.Assert.*;

public class HandEvaluatorTest {


    @Test
    public void rangHand() {
        String[] hand1 = new String[]{"2c", "2d", "3h", "Ad", "7d"};
        int i = HandEvaluator.rankHand(hand1);
        assertEquals(2, i);
    }


    @Test
    public void valueOf() {
        String line = "2d 3h";
        String[] lineArray = HandEvaluator.valueOf(line);
        assertTrue(lineArray instanceof String[]);
        assertEquals(2, lineArray.length);
    }


    @Test
    public void nominal() {
        char c = 'A';
        int nominal = HandEvaluator.nominal(c);
        assertEquals(13, nominal);
    }

    @Test
    public void nominalFail(){
        char c='B';
        int nominal = HandEvaluator.nominal(c);
        assertEquals(0 , nominal);
    }





}