package ps.model.evulator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * тест функциональности класса {@link HandEvaluator}
 */
public class HandEvaluatorTest {

    @Test
    public void rankHand() {
        String [] hand = {"2c" , "2h" , "3d" , "Ad" , "7h"}; // pair = 2 ; two pair  = 3
        int i = HandEvaluator.rankHand(hand);
        assertEquals(2 , i);
    }
}