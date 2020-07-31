package shop.service;


import shop.model.Customer;

import java.util.List;

//TODO это не правильно переделаю
public interface CustomService {

    void save(Customer customer);
    List<Customer> list();
    void remove(long id);
    Customer findById(long id);


}
