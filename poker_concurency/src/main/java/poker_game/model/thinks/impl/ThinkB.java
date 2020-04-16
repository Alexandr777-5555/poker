package poker_game.model.thinks.impl;

import poker_game.model.thinks.Think;

/**
 *
 * реализация думать по схеме B
 */

public class ThinkB  implements Think {
    @Override
    public int bet(int rang) {
        if(rang<1) throw new IllegalArgumentException("Unknown rang");
        int bet = 0;
        if (rang <= 10) {
            bet = 100;
        }
        if (rang > 10) {
            bet = 200;
        }
        return bet;
    }
}
