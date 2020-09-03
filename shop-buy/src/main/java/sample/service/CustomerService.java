package sample.service;

import org.springframework.stereotype.Service;
import sample.model.Customer;

import java.util.List;


public interface CustomerService {

    List<Customer> findAll();

}
