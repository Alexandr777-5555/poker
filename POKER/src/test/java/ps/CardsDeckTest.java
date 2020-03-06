package ps;

import org.junit.Before;
import org.junit.Test;
import ps.model.deckIMPL.CardsDeck;

import static org.junit.Assert.*;

/**
 * тест функциональности класса {@link CardsDeck}
 */
public class CardsDeckTest {

    private CardsDeck deck;

    @Before
    public void setUp() throws Exception {
        deck = new CardsDeck();
        deck.shuffle();
    }

    @Test
    public void testGetCards1Player() {


        String cards1Player = deck.getCardsPlayer(1);
        String card1 = deck.getCard(0);
        String card2 = deck.getCard(1);
        String cards = card1 + card2;

        String hand = CardsDeck.splitsSpace(cards);

        assertEquals(hand, cards1Player);

        System.out.println(hand);


    }
}