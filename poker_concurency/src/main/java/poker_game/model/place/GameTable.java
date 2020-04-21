package poker_game.model.place;


import poker_game.model.players.Player;

import java.util.List;

/**
 *
 * класс представляет собой игральный стол , за которым
 * может быть не более 9 игроков
 *
 *
 *
 *
 */

public class GameTable implements Table {


    /**
     * колода карт
     */
    private Deck deckOfCards;

    private List<Player> players;








    /**
     * возвращаем победителя в игре
     * @return
     */
    @Override
    public Player game() {
        return null;
    }



}
