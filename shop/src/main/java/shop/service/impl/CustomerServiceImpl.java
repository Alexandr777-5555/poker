package shop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.domain.Customer;
import shop.repo.CustomerRepository;
import shop.service.CustomerService;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final CustomerRepository customerRepository;

    //  public CustomerServiceImpl(@Qualifier("jdbcCustomer") CustomerRepository
    public CustomerServiceImpl(@Qualifier("hibCustomer") CustomerRepository
                                       customerRepository) {
        this.customerRepository = customerRepository;
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("Alex");
        customer.setLastName("Avd");
        customerRepository.add(customer);

        customer = new Customer();
        customer.setId(2L);
        customer.setFirstName("AAA");
        customer.setLastName("BBB");
        customerRepository.add(customer);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.add(customer);
    }

    @Override
    public List<Customer> list() {
        return customerRepository.findAll();
    }


    @Override
    public void remove(long id) {
        customerRepository.remove(id);
    }

    @Override
    public Customer findById(long id) {
        return customerRepository.findOne(id);
    }


}
