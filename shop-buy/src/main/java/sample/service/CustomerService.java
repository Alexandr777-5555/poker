package sample.service;

import sample.model.Customer;

import java.util.List;


public interface CustomerService {

    List<Customer> findAll();
    List<Customer> findAllWithPurchases();

}
