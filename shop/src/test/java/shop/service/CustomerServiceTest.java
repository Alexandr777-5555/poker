package shop.service;

import org.junit.Before;
import org.junit.Test;
import shop.model.Customer;
import shop.repo.memory.InMemoryCustomRepo;
import shop.service.impl.CustomerServiceImpl;

import static org.junit.Assert.*;

public class CustomerServiceTest {


    private CustomerService service;
    private Customer customer;


    @Before
    public void init() {
        customer = new Customer();
        customer.setId(1L);
        service = new CustomerServiceImpl(new InMemoryCustomRepo());
        service.create(customer);
    }


    @Test
    public void create() {
        assertEquals(customer, service.find(customer));
    }

    @Test
    public void remove() {
        service.remove(customer);
        assertEquals(0 , service.findAll().size());
    }

    @Test
    public void find() {
        Customer customer = service.find(this.customer);
        assertEquals(customer, this.customer);
    }
}