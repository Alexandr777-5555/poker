package ps.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StopWatch;
import ps.config.PokerConfig;
import ps.counters.Counter;
import ps.model.Table;
import ps.model.base.Player;
import ps.model.tableIMPL.GameTable;
import ps.service.PlayerService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(PokerConfig.class);
        Table gameTable = context.getBean("table", Table.class);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("poker");
        gameTable.game();
        stopWatch.stop();
        System.out.println("длительность игры :" + stopWatch.getTotalTimeMillis() + "ms");

        Counter counter = (Counter) gameTable;
        System.out.println("вызывался метод game :" + counter.getCount());


        PlayerService bean = context.getBean(PlayerService.class);
        Player player=new Player(4 , 20);
        Player player2=new Player(5 , 20);
        bean.save(player);
        bean.save(player2);

        List<Player> list = bean.list();
        System.out.println("количество : " + list.size());




    }
}
