package ps;

import org.junit.Before;
import org.junit.Test;
import ps.model.*;
import ps.model.base.Player;
import ps.model.deckIMPL.CardsDeck;
import ps.model.playerIMPL.GamePlayer;
import ps.model.tableIMPL.GameTable;
import ps.model.thinkIMPL.Brain;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * тест функциональности игрового стола {@link GameTable}
 */
public class GameTableTest {

    List<Player> players;
    Deck deck;
    private Table table;
   // private  Think think;

    @Before
    public void setUp() throws Exception {

       // think=new Brain();

        Player player1 = new GamePlayer(1, 7 );
        Player player2 = new GamePlayer(2, 6 );

        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        deck = new CardsDeck();
        table = new GameTable(players);
    }

    @Test
    public void dealCards() {
        for (Player player : players) {
            player.setHand(deck.getCardsPlayer(player.getId()));
        }

        Player player = players.get(0);
        String hand = player.getHand();
        assertEquals(hand, deck.getCardsPlayer(1));
    }


    @Test
    public void checkGameOver() {

        assertEquals(2, players.size());

        Player player = players.get(1);
        player.setChips(0);
        table.checkGameOver();
        assertEquals(1, players.size());

    }

}