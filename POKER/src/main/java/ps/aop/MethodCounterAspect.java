package ps.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import ps.counters.Counter;
import ps.counters.countIMPL.CounterMethodGame;

@Aspect
public class MethodCounterAspect {

    @DeclareParents(value = "ps.model.Table+", defaultImpl = CounterMethodGame.class)
    public static Counter counts;


    @Before( value = "execution(* ps.model.Table.game(..)) && this(count)" , argNames = "count")
    public void beforeEndDealCards(Counter count) {
        count.count();
    }



}
