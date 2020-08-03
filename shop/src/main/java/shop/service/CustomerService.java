package shop.service;


import shop.model.Customer;

import java.util.List;

public interface CustomerService {

    void create(Customer customer);

    void remove(Customer customer);

    void remove(long id);

    Customer find(Customer customer);

    List<Customer> findAll();

    boolean exists(Customer customer);

}
