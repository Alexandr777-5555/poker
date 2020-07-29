package shop.repo;


import shop.model.Customer;

import java.util.List;


// TODO остановился на этом классе! не правильный класс !!! переделаю в CustomerRepo

public interface CustomerRepository {

  Customer add(Customer customer);
  List<Customer> findAll();
  void remove(long id);
  Customer findOne(long id);

}
