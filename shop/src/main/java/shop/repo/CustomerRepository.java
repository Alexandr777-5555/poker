package shop.repo;


import shop.model.Customer;

import java.util.List;


public interface CustomerRepository {

  Customer add(Customer customer);
  List<Customer> findAll();
  void remove(long id);
  Customer findOne(long id);

}
