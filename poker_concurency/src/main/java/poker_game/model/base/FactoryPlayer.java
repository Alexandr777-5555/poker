package poker_game.model.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import poker_game.model.thinks.impl.ThinkA;
import poker_game.model.thinks.impl.ThinkB;
import poker_game.model.thinks.impl.ThinkC;


/**
 *
 * фабрика по созданию игроков
 */
public class FactoryPlayer {

    private static final Logger log = LoggerFactory.getLogger(FactoryPlayer.class);
    /***
     *  создание игрока
     * @param id  - id игрока начинается от 1
     * @param chips фишки игрока
     * @param scheme схема игры -> есть A , B, C
     * @return
     */
    public static Player createPlayer(int id, int chips , String  scheme){
        if(id<1 || chips<1 || scheme.isEmpty() || scheme==null) throw new IllegalArgumentException("unknown id or chips or scheme null");

        if("A".equals(scheme)){
            log.info("create Player A");
            return new PlayerA(id, chips, new ThinkA());
        }
        if("B".equals(scheme)){
            log.info("create Player B");
            return new PlayerB(id, chips, new ThinkB());
        }
        if("C".equals(scheme)){
            log.info("create Player C");
            return new PlayerC(id, chips, new ThinkC());
        }
        throw new IllegalArgumentException("unknown player");
    }

}
