package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.domain.Customer;
import shop.repo.CustomerRepository;
import shop.service.CustomerService;

import java.util.List;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;


    public CustomerServiceImpl(@Qualifier("jdbcCustomer") CustomerRepository
                                       customerRepository) {
        this.customerRepository = customerRepository;
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


}
