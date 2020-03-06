package ps.model.base;


import org.springframework.beans.factory.annotation.Autowired;
import ps.model.Think;

import javax.persistence.*;

@Table
@Entity
public  class Player {

    @Id
    private int id;
    private int chips;
    @Transient
    private String hand;
    @Transient
    private int strongHand;
    @Transient
    private boolean win;
    @Autowired
    @Transient
    private Think think;


    public Player() {
    }

    public Player(int id, int chips ) {
        if((id <1)&&(chips<0)) throw new IllegalArgumentException("bad");
        this.id = id;
        this.chips = chips;
        this.think= think;
    }

    public int getId() {
        return id;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public String getHand() {
        return hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }


    public int bet() {
        int rang = rangHand();
        int bet = 0;
        bet = think.bet(rang);
        return bet;
    }


    public int rangHand() {
        int rang = determiningCardRank(getHand()); // определеяем ранг
        return rang;
    }


    /**
     * сумма которую передаем в банк
     *
     * @param total
     * @return
     */

    public int chipsInPot(int total) {

        int chips = getChips();
        int amount = 0;

        if (total >= chips) {
            setChips(0);
            return amount = chips;
        }

        amount = chips - total;
        setChips(amount);

        return total;
    }


    /**
     * определение ранга карманных карт на префлопе у игрока
     *
     * @return
     */
    public int determiningCardRank(String hand) {

        int rang;
        String[] s = valueOf(hand);
        char a = s[0].charAt(0);
        char b = s[1].charAt(0);
        int rangCard1 = nominal(b);
        int rangCard2 = nominal(a);

        if (rangCard1 == rangCard2) {
            rang = (rangCard1 + rangCard2) + 2; //
        } else {
            rang = (rangCard1 + rangCard2) / 2;
        }

        return rang;
    }


    /**
     * метод strokaVMassiv преобразует строку в массив
     *
     * @param line
     * @return
     */
    private String[] valueOf(String line) {
        String[] arrline = line.split(" ");
        return arrline;
    }


    /**
     * Метод nominal возвращает число из указанного символа пример Q (дама)
     * возвращаем 12 число
     *
     * @param handType
     * @return возвращает число из указанного символа
     */
    private int nominal(char handType) {

        switch (handType) {

            case '2':
                return 1;
            case '3':
                return 2;
            case '4':
                return 3;
            case '5':
                return 4;
            case '6':
                return 5;
            case '7':
                return 6;
            case '8':
                return 7;
            case '9':
                return 8;
            case 'T':
                return 9;
            case 'J':
                return 10;
            case 'Q':
                return 11;
            case 'K':
                return 12;
            case 'A':
                return 13;

            default:
                return 0;

        }

    }

    public int getStrongHand() {
        return strongHand;
    }

    public void setStrongHand(int strongHand) {
        this.strongHand = strongHand;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}