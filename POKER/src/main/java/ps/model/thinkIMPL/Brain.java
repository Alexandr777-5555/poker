package ps.model.thinkIMPL;

import ps.model.Think;


public class Brain implements Think {

    @Override
    public int bet(int rang) {
        int bet = 0;
        if (rang <= 8) {
            bet = 100;
        }
        if (rang > 8) {
            bet = 200;
        }
        return bet;
    }

}
