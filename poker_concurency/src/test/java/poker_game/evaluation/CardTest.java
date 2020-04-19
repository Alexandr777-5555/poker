package poker_game.evaluation;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {


    @Test
    public void getIndex() {

        Card card = new Card('2', 'c');
        int index = card.getIndex();
        assertEquals(15, index);
    }





}