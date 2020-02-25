package ps;

import ps.CardsDeck;

public interface Table {


    /**
     * раздать карты игрокам
     */
    void dealCards(CardsDeck deck);

    void dealFlop();

    void dealTern();

    void dealRiver();

    void game();
}
