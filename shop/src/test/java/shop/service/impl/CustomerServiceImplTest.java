package shop.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import shop.config.TestConfig;
import shop.exceptions.CustomerNotFoundException;
import shop.exceptions.DuplicateCustomerException;
import shop.model.Customer;
import shop.service.CustomerService;

import java.util.List;

import static org.junit.Assert.*;


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

    @Test
    public void create() {
        Customer c = new Customer();
        service.create(c);
        List<Customer> all = service.findAll();
        assertEquals(4, all.size());
    }


    @Test
    public void exists() {
        Customer c = new Customer();
        c.setId(2);
        boolean exists = service.exists(c);
        assertTrue(exists);
    }

    @Test
    public void noExists() {
        Customer customer = new Customer();
        customer.setId(4);
        boolean exists = service.exists(customer);
        assertFalse(exists);
    }


    @Test(expected = DuplicateCustomerException.class)
    public void duplicateExpected() {
        Customer c = new Customer();
        c.setId(1);
        service.create(c);
    }

    @Test(expected = NullPointerException.class)
    public void deleteExpectedNPE() {
        service.remove(4);
    }


    @Test(expected = CustomerNotFoundException.class)
    public void deleteNotFound() {
        Customer customer = new Customer();
        customer.setId(4);
        service.remove(customer);
    }


    @Test(expected = CustomerNotFoundException.class)
    public void findNotFound() {
        Customer customer = new Customer();
        customer.setId(4);
        service.find(customer);
    }


    @Test
    public void countRow() {
        int i = countRowsInTable("Customer");
        assertEquals(i, 3);
    }

}