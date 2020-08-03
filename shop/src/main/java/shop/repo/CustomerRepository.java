package shop.repo;


import shop.model.Customer;

import java.util.List;


public interface CustomerRepository {

    void create(Customer customer);

    void remove(Customer customer);

    void remove(long id);

    Customer find(Customer customer);

    boolean exists(Customer customer);

    List<Customer> findAll();


}
