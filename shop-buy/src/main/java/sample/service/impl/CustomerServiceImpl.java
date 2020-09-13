package sample.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sample.model.Customer;
import sample.repository.CustomerRepository;
import sample.service.CustomerService;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findAllWithPurchases() {
        return customerRepository.findAllWithPurchases();
    }



}
