package shop.repo.hibernate;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import shop.config.HibernateConfig;
import shop.model.Cost;
import shop.model.Item;
import shop.repo.ItemRepository;

import java.util.List;

import static java.lang.System.out;
import static org.junit.Assert.*;


public class HibernateItemRepositoryTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private GenericApplicationContext ctx;

    private ItemRepository repository;

    @Before
    public void setup() {
        ctx = new AnnotationConfigApplicationContext(HibernateConfig.class);
        repository = ctx.getBean(ItemRepository.class);
        assertNotNull(repository);
    }


    @Test
    public void findAll() {
        List<Item> list = repository.findAll();
        assertNotNull(repository);
        assertEquals(1, list.size());
    }

    @Test
    public void findAllWithCost() {
        List<Item> items = repository.findAllWithCost();
        assertEquals(1, items.size());
        listItemWithCost(items);
    }


    private void listItemWithCost(List<Item> items) {
        for(Item item:items){
            log.info(item.toString());
            if(item.getCosts()!=null){
                log.info("in!!!");
                for(Cost cost: item.getCosts()){
                    log.info("cost in!!!");
                    log.info(cost.toString());
                }
            }
        }
    }

}