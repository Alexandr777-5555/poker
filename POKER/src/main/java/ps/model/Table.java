package ps.model;

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
}
