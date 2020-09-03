package sample.service.impl;

import org.springframework.stereotype.Service;
import sample.model.Customer;
import sample.repository.CustomerRepository;
import sample.service.CustomerService;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {


    private CustomerRepository customerRepository;


    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }




}
