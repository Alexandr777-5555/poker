package shop.repo.jpa;

import shop.model.Customer;
import shop.repo.CustomerRepository;

import java.util.List;


public class JpaCustomerEmRepository implements CustomerRepository {
    @Override
    public void create(Customer customer) {

    }

    @Override
    public void remove(Customer customer) {

    }

    @Override
    public void remove(long id) {

    }

    @Override
    public Customer find(Customer customer) {
        return null;
    }

    @Override
    public boolean exists(Customer customer) {
        return false;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }
}
