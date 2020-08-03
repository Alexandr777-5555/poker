package shop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import shop.model.Customer;
import shop.repo.CustomerRepository;
import shop.service.CustomerService;

import java.time.LocalDate;
import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private CustomerRepository repository;

    public CustomerServiceImpl(@Qualifier("jpaCustomerEmRepository") CustomerRepository repository) {
        this.repository = repository;
        Customer customer = new Customer();
        customer.setFirstName("Alex");
        customer.setLastName("Avd");
        customer.setDateOfBirth(LocalDate.of(1982, 6, 23));
        repository.create(customer);

        customer = new Customer();
        customer.setFirstName("AAA");
        customer.setLastName("BBB");
        customer.setDateOfBirth(LocalDate.of(2020, 1, 13));
        repository.create(customer);
    }


    @Override
    public void create(Customer customer) {
        repository.create(customer);
    }

    @Override
    public void remove(Customer customer) {
        repository.remove(customer);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public void remove(long id) {
        log.info("delete customer by id " + id);
        repository.remove(id);
    }

    @Override
    public Customer find(Customer customer) {
        return repository.find(customer);
    }

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean exists(Customer customer) {
        return repository.exists(customer);
    }
}
