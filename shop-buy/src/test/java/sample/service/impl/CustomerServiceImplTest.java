package sample.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.config.TestConfig;
import sample.model.Customer;
import sample.model.Purchases;
import sample.service.CustomerService;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@ActiveProfiles("test")
public class CustomerServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomerService customerService;


    @Test
    @Sql({"classpath:test/data.sql"})
    public void findAll() {
        List<Customer> list = customerService.findAll();
        assertEquals(3, list.size());
    }

    @Test
    @Sql({"classpath:test/data.sql"})
    public void findAllWithPurchases() {
        List<Customer> list = customerService.findAllWithPurchases();
        assertEquals(3, list.size());
        listCustomersWithPurchases(list);
    }


    @Test
    public void testInsert() {

        Customer customer = new Customer();
        customer.setFirstName("Alexander");
        customer.setLastName("Avdeev");
        customer.setBirthDate(new Date(
                (new GregorianCalendar(1982, 6, 23)).getTime().getTime()));

        Purchases purchases = new Purchases();
        purchases.setProductId("Квартира");
        purchases.setBuy(new java.sql.Date(
                (new GregorianCalendar(1961, 7, 18)).getTime().getTime()));
        ;
        customer.addPurchases(purchases);

        customerService.save(customer);
        assertNotNull(customer.getId());

        List<Customer> customers = customerService.findAll();
        assertEquals(1, customers.size());

        customers = customerService.findAllWithPurchases();
        assertEquals(1, customers.size());

        listCustomersWithPurchases(customers);
    }


    private void listCustomersWithPurchases(List<Customer> list) {
        logger.info(" ---- Listing customers with purchases:");
        list.forEach(c -> {
            logger.info(c.toString());
            if (c.getPurchases() != null) {
                c.getPurchases().forEach(pur -> logger.info("\t purch" + pur.toString()));
            }
            if (c.getProducts() != null) {
                c.getProducts().forEach(p -> logger.info("Product " + p.getProductId()));
            }
        });
    }


}