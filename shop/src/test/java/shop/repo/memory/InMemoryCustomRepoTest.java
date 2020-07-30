package shop.repo.memory;

import org.junit.Before;
import org.junit.Test;
import shop.exceptions.CustomerNotFoundException;
import shop.exceptions.DuplicateCustomerException;
import shop.model.Customer;
import shop.repo.CustomerRepository;

import static org.junit.Assert.*;

public class InMemoryCustomRepoTest {

    private Customer customerExists;
    private Customer customerNew;
    private CustomerRepository repository;

    @Before
    public void init() {
        customerExists = new Customer();
        customerExists.setId(1L);
        customerNew = new Customer();
        customerNew.setId(2L);
        repository = new InMemoryCustomRepo();
        repository.create(customerExists);
    }

    @Test
    public void customerExists() {
        assertTrue(repository.exists(customerExists));
        assertFalse(repository.exists(customerNew));
    }


    @Test
    public void createCustomer() {
        repository.create(customerNew);
        assertEquals(repository.find(customerNew), customerNew);
    }


    @Test(expected = DuplicateCustomerException.class)
    public void createDuplicateCustomer() {
        repository.create(customerExists);
    }


    @Test
    public void removeExistCustomer() {
        repository.remove(customerExists);
        assertFalse(repository.exists(customerExists));
    }

    @Test
    public void findCustomers() {
        assertEquals(1, repository.findAll().size());
    }


    @Test(expected = CustomerNotFoundException.class)
    public void removeNotExistCustomer() {
        repository.remove(customerNew);
    }


    @Test
    public void findExistCustomer() {
        Customer customer = repository.find(customerExists);
        assertEquals(customer, customerExists);
    }


    @Test(expected = CustomerNotFoundException.class)
    public void findNotExistCustomer() {
        repository.find(customerNew);
    }


}