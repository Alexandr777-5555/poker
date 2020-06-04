package shop.repo;


import shop.domain.Customer;

import java.util.List;

public interface CustomerRepository {

  Customer add(Customer customer);
  List<Customer> findAll();
  void remove(int id);
  Customer findOne(int id); 

}
