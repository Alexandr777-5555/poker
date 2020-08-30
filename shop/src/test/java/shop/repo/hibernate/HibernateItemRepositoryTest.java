package shop.repo.hibernate;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import shop.config.HibernateConfig;
import shop.model.Item;
import shop.repo.ItemRepository;

import java.util.List;

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

}