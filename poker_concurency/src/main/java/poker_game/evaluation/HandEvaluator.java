package poker_game.evaluation;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HandEvaluator {

    private static final Logger log = LoggerFactory.getLogger(HandEvaluator.class);

    private static final int HIGH = 1;
    private static final int PAIR = 2;
    private static final int TWOPAIR = 3;
    private static final int SET = 4;

    /**
     * определение ранга руки игрока
     *
     * @param hand
     * @return
     */
    public static int rankHand(String[] hand) {
        int rang = 0;
        ArrayList<Integer> maxHand = new ArrayList<>();
        Map<Integer, Long> collect = Stream.of(hand)
                .collect(Collectors.groupingBy(c -> new Card(c).getRank(), Collectors.counting()));
        //collect.forEach((s, count) -> System.out.println(s + " " + count));
        List<Long> valueList = new ArrayList(collect.values());
        int countPair = 0;
        for (Long value : valueList) {
            if (value < 2) {
                //TODO пробежимся по числам ! добавим их в список и получим старшую!!!
                rang = HIGH;
            }
            if (value > 1) {
                countPair++;
                rang = PAIR;
                if (countPair > 1) {
                    rang = TWOPAIR;
                }
            }
            if (value > 2) {
                rang = SET;
            }
            if (value > 3) {
                log.info("Карэ 4 карты одного ранга");
            }
            maxHand.add(rang);
        }
        Integer max = Collections.max(maxHand);
        return max;
    }


    /**
     * определение ранга карманных карт на префлопе у игрока
     *
     * @return
     */
    public static int determiningCardRank(String hand) {

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
     * метод valueOf преобразует строку в массив c пробелом
     *
     * @param line
     * @return
     */
    public static String[] valueOf(String line) {
        if (line.isEmpty() || line==null)
            throw new IllegalArgumentException("line is empty");

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
    public static int nominal(char handType) {
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


    /**
     * название карт
     *
     * @return
     */
    public static String nameHand() {
        return null;
    }


}
