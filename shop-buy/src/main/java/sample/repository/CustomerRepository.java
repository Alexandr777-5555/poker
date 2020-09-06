package sample.repository;

import sample.model.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();
    List<Customer> findAllWithPurchases();

}
