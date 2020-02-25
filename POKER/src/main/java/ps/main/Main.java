package ps.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StopWatch;
import ps.Player;
import ps.Table;

public class Main {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");



//        // Player player10 = context.getBean("player10", Player.class);
//        Player player1 = context.getBean("player1", Player.class);
//
//        Player player2 = context.getBean("player2", Player.class);
//
//        Player player3 = context.getBean("player3", Player.class);
//




        Table gameTable = context.getBean("table", Table.class);


        StopWatch stopWatch = new StopWatch();
        stopWatch.start("poker");
        gameTable.game();
        stopWatch.stop();
        System.out.println("сколько :"
                + stopWatch.getTotalTimeMillis() + "ms");

    }
}
