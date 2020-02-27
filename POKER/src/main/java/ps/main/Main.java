package ps.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractRefreshableConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StopWatch;
import ps.GameTable;
import ps.Player;
import ps.Table;

public class Main {
    public static void main(String[] args) {

        //TODO тут заменить что это файл конфигурации  и все будет работать!!!
     //   ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
       ApplicationContext context =new AnnotationConfigApplicationContext("ps.config");



       Table gameTable = context.getBean("table" , Table.class);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("poker");
        gameTable.game();
        stopWatch.stop();
        System.out.println("сколько :"
                + stopWatch.getTotalTimeMillis() + "ms");

    }
}
