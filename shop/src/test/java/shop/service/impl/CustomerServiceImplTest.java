package shop.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import shop.config.TestConfig;
import shop.model.Customer;
import shop.service.CustomerService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@ActiveProfiles("test")
public class CustomerServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {


    @Autowired
    private CustomerService service;

    @Test
    public void findAll() {
        List<Customer> all = service.findAll();
        assertNotNull(all);
        assertEquals(3, all.size());
    }

    @Test
    public void find() {
        Customer c = new Customer();
        c.setId(1L);
        Customer customer = service.find(c);
        assertNotNull(customer);
    }

    @Test
    public void delete() {
        service.remove(1);
        List<Customer> all = service.findAll();
        assertEquals(2, all.size());
    }





}