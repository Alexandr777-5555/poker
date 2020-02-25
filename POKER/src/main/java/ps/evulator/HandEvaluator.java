package ps.evulator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HandEvaluator {

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
        Map<Integer, Long> collect = Stream.of(hand) //"2c", "Ah", "4d", "2s", "Kc"
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
                System.out.println("Карэ 4 карты одного ранга!!!!!");
            }
            maxHand.add(rang);
        }
        Integer max = Collections.max(maxHand);
        return max;
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
