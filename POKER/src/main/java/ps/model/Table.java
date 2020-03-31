package ps.model;

import ps.model.base.Player;

public interface Table {


    /**
     * раздать карты игрокам
     */
    void dealCards(Deck deck);


    /**
     * метод игры в покер
     */
    void game();

    /**
     * метод проверяет окончания  игры игрока
     */
    void checkGameOver();


    Player getWinPlayer();


}
