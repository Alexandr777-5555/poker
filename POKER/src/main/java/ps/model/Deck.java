package ps.model;

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
     * получить карманные карты для игрока
     * @param id идентификатор игрока  id>0
     * @return
     */
    String getCardsPlayer(int id);


    /**
     * получить карты флопа
     * @return
     */
    String getFlop();


    /**
     * получить карту терна
     * @return
     */
    String getTern();

    /**
     * получить карту ривера
     * @return
     */
    String getRiver();


    /**
     * получить все общие карты
     * @return
     */
    String commonCards();


    /**
     * рука игрока с общими картами
     * @param id
     * @return
     */
    String allHandPlayer(int id);
}
