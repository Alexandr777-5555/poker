package sample.service;

import sample.model.Customer;

import java.util.List;


public interface CustomerService {

    Customer save(Customer customer);
    List<Customer> findAll();
    List<Customer> findAllWithPurchases();

}
