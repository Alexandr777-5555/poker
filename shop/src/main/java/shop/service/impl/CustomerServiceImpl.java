package shop.service.impl;

import org.springframework.stereotype.Service;
import shop.domain.Customer;
import shop.repo.CustomerRepository;
import shop.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void save(Customer customer) {
        customerRepository.add(customer);
    }



}
