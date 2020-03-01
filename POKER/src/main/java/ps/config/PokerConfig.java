package ps.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ps.*;
import ps.aop.CheckDealCards;
import ps.counters.BeanCounter;
import ps.counters.DealCounter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy // включаем автоматическое проксирование
public class PokerConfig {


    @Bean
    public Player player1() {
        return new GamePlayer(1, 3000);
    }


    @Bean
    public Player player2() {
        return new GamePlayer(2, 3000);
    }


    @Bean
    public Player player3() {
        return new GamePlayer(3, 3000);
    }


    @Bean
    public List<Player> list() {
        return new ArrayList<Player>(Arrays.asList(player1(), player2(), player3()));
    }


    @Bean(name = "table")
    public Table table() {
        return new GameTable(list());
    }


    @Bean
    public Deck deck() {
        return new CardsDeck();
    }

    @Bean
    public BeanCounter beanCounter() {
        return new BeanCounter();
    }

    @Bean
    public CheckDealCards dealCards() {
        return new CheckDealCards();
    }


    @Bean
    public DealCounter dealCounter() {
        return new DealCounter();
    }
//
//    @Bean
//    public DealCounter dealCounter(){
//        return new DealCounter();
//    }
}
