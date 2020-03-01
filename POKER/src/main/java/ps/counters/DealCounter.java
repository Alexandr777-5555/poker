package ps.counters;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * считаем количество раздач
 */
@Aspect
public class DealCounter {

    private int count;

    /**
     *
     */
    public void calcBefore(){

      System.out.println("начинаем считать :" + count);
    }



    // TODO так работает!!! если метод проксированный ты его по другому должен разбирать
//    @After("execution(* ps.GameTable.game(..))")
//    public void calcAfter(){
//        count++;
//        System.out.println("закончили считать :" + count );
//    }


    // TODO НЕ РАБОТАЕТ НУЖНО УЗНАТЬ КАК СЧИТАТЬ КОЛИЧЕСТВО РАЗДАЧ !!!
    @Around("execution(* ps.GameTable.checkGameOver(..))")
    public void counter(ProceedingJoinPoint point)  {

         count=0;
        try {
            point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        count++;

        System.out.println("закончили считать :" + count );

    }




//   public  int getCount() {
//        return count;
//    }
//
//    public void setCount(int count) {
//        this.count = count;
//    }
}
