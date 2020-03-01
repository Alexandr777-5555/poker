package ps.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CheckDealCards {
    private int count=0;

    @Pointcut("execution(* *.game(..))")
    public void perform() { }

    @Before("perform()")
    public void beforeDealCards() {
        System.out.println("перед игрой");
    }


    @After("execution(* ps.GameTable.game(..))")
    public void afterDealCards() {
        System.out.println("после игры");
    }


}
