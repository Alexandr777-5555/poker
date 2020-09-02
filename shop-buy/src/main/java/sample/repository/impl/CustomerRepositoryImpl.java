package sample.repository.impl;

import org.springframework.stereotype.Repository;
import sample.model.Customer;
import sample.repository.CustomerRepository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public List<Customer> findAll() {
        return null;
    }
}
