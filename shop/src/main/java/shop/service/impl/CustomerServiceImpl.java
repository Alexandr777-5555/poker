package shop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import shop.model.Customer;
import shop.repo.CustomRepo;
import shop.service.CustomerService;

import java.time.LocalDate;
import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final CustomRepo customerRepository;

    // public CustomerServiceImpl(@Qualifier("jpaCustomer") CustomerRepository customerRepository) {
    public CustomerServiceImpl(@Qualifier("jpaCustomerEm") CustomRepo customerRepository) {

        this.customerRepository = customerRepository;
        Customer customer = new Customer();
        customer.setFirstName("Alex");
        customer.setLastName("Avd");
        customer.setDateOfBirth(LocalDate.of(1982, 6, 23));
        customerRepository.add(customer);

        customer = new Customer();
        customer.setFirstName("AAA");
        customer.setLastName("BBB");
        customer.setDateOfBirth(LocalDate.of(2020, 1, 13));
        customerRepository.add(customer);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.add(customer);
    }

    @Override
    public List<Customer> list() {
        log.info(" size Customers " + customerRepository.findAll().size());
        return customerRepository.findAll();
    }


    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public void remove(long id) {
        log.info("delete customer by id " + id);
        customerRepository.remove(id);
    }

    @Override
    public Customer findById(long id) {
        return customerRepository.findOne(id);
    }

}
