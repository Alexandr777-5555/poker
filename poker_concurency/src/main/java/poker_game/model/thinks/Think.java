package poker_game.model.thinks;


/**
 * класс Think думать
 *
 */

public interface Think {


    /**
     * В зависимости от ранга карты игрок будет делать ставку.
     * У Каждого игрока определенные условия по принятию решений
     *
     * @param rang ранг карманных карт
     * @return ставка игрока
     */
    int bet(int rang);


}
