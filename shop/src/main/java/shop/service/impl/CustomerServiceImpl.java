package shop.service.impl;

import shop.model.Customer;
import shop.repo.CustomerRepository;
import shop.service.CustomerService;

import java.util.List;


public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
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
