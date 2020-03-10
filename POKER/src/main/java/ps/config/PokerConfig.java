package ps.config;


import org.springframework.context.annotation.*;
import ps.aop.CheckDealCards;
import ps.aop.MethodCounterAspect;
import ps.counters.BeanCounter;
import ps.model.Deck;
import ps.model.Table;
import ps.model.Think;
import ps.model.base.Player;
import ps.model.deckIMPL.CardsDeck;
import ps.model.tableIMPL.GameTable;
import ps.model.thinkIMPL.Brain;
import ps.web.controller.HomeController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy // включаем автоматическое проксирование
@Import(InfrastructureConfig.class)
@ComponentScan(basePackages = {"ps"})
public class PokerConfig {


    @Bean
    public Player player1() {
        return new Player(1, 3000 );
    }


    @Bean
    public Player player2() {
        return new Player(2, 3000);
    }


    @Bean
    public Player player3() {
        return new Player(3, 3000 );
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
    public Think think() {
        return new Brain();
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
    public MethodCounterAspect counterAspect(){
        return new MethodCounterAspect();
    }



}
