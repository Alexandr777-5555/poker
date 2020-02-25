package ps;


import java.util.Arrays;
import java.util.Collections;

/**
 * колода карт 4х13
 */
public class CardsDeck implements Deck {

    // колода карт
    private String[] deck = {"2d", "3d", "4d", "5d", "6d", "7d", "8d", "9d", "Td", "Jd", "Qd", "Kd", "Ad",
            "2c", "3c", "4c", "5c", "6c", "7c", "8c", "9c", "Tc", "Jc", "Qc", "Kc", "Ac",
            "2s", "3s", "4s", "5s", "6s", "7s", "8s", "9s", "Ts", "Js", "Qs", "Ks", "As",
            "2h", "3h", "4h", "5h", "6h", "7h", "8h", "9h", "Th", "Jh", "Qh", "Kh", "Ah"};


    @Override
    public void shuffle() {
        Collections.shuffle(Arrays.asList(deck));
    }


    @Override
    public void print() {
        for (String card : deck) {
            System.out.println(card);
        }
    }


    @Override
    public String getCards1Player() {
        String card1 = deck[0];
        String card2 = deck[1];
        String player = card1 + card2;

        return splitsSpace(player);
    }

    @Override
    public String getCards2Player() {

        String card1 = deck[2];
        String card2 = deck[3];
        String player = card1 + card2;
        return splitsSpace(player);
    }


    @Override
    public String getCards3Player() {

        String card1 = deck[4];
        String card2 = deck[5];
        String player = card1 + card2;

        return splitsSpace(player);
    }

    /**
     * получить Карты ФЛОПА 3 карты
     *
     * @return
     */
    public String getFlop() {

        String card19 = deck[19]; // из массива берем 19 карту
        String card20 = deck[20]; // из массива берем 20 карту
        String card21 = deck[21]; // из массива берем 21 карту
        String player = card19 + card20 + card21;

        return splitsSpace(player);

    }


    /**
     * получить Карту Терна 1 карта
     *
     * @return
     */
    public String getTern() {
        String card22 = deck[22]; // из массива берем 22 карту
        return splitsSpace(card22);
    }

    /**
     * получить Карту Ривера 1 карта
     *
     * @return
     */
    public String getRiver() {
        String card23 = deck[23]; // из массива берем 23 карту
        return splitsSpace(card23);
    }

    private String splitsSpace(String card) {
        String cards = card.replaceAll("(.{2})", "$1 "); //разделяет пробел
        return cards;
    }


    /**
     * общие карты
     *
     * @return
     */
    public String commonCards() {
        String cards = getFlop() + getTern() + getRiver();
        return cards;
    }



    /**
     * рука игрока с общими картами
     * @param id
     * @return
     */
    public String allHandPlayer(int id) {
        String hand = commonCards(); // общие карты
        if (id == 1) {
            return hand + getCards1Player();
        }
        if (id == 2) {
            return hand + getCards2Player();
        }
        if (id == 3) {
            return hand + getCards3Player();
        }
        return "null";
    }


    /**
     * приводит строку к массиву строк
     *
     * @param str
     * @return
     * @throws NumberFormatException
     */
    public static String[] valueOf(String str) throws NumberFormatException {
        String[] subStr = str.split(" ");
        return subStr;

    }

}
