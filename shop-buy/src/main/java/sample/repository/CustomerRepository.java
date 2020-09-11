package sample.repository;

import sample.model.Customer;

import java.util.List;

public interface CustomerRepository {

    Customer save(Customer customer);
    List<Customer> findAll();
    List<Customer> findAllWithPurchases();

}
