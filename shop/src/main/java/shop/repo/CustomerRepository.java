package shop.repo;


import shop.model.Customer;

import java.util.List;


public interface CustomerRepository {

    void create(Customer customer);

    void remove(Customer customer);

    Customer find(Customer customer);

    List<Customer> findAll();

    boolean exists(Customer customer);


}
