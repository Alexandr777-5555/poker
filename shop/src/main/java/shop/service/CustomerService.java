package shop.service;


import shop.domain.Customer;

import java.util.List;

public interface CustomerService {

    void save(Customer customer);
    List<Customer> list();
    void remove(long id);
    Customer findById(long id);


}
