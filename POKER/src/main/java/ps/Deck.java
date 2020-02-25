package ps;

public interface Deck {

    /***
     *
     * перемешать колоду карт
     */
    void shuffle();

    /**
     * печать колоды карт
     */
    void print();

    /**
     * получить карманные карты 1 игрока
     * @return
     */
    String getCards1Player();

    /**
     * получить карманные карты 2 игрока
     * @return
     */
    String getCards2Player();

    /**
     *
     * получить кармманые карты 3 игрока
     * @return
     */
    String getCards3Player();
}
