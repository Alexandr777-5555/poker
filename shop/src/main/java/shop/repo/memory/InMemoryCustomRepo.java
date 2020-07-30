package shop.repo.memory;

import shop.exceptions.CustomerNotFoundException;
import shop.exceptions.DuplicateCustomerException;
import shop.model.Customer;
import shop.repo.CustomerRepository;

import java.util.*;


public class InMemoryCustomRepo implements CustomerRepository {

    private Map<Long, Customer> customers;

    public InMemoryCustomRepo() {
        customers = Collections.synchronizedMap(new HashMap<Long, Customer>());
    }

    @Override
    public void create(Customer customer) {
        if (exists(customer)) {
            throw new DuplicateCustomerException();
        }
        customers.put(customer.getId(), customer);
    }

    @Override
    public void remove(Customer customer) {
        if (!exists(customer)) {
            throw new CustomerNotFoundException();
        }
        customers.remove(customer.getId());
    }

    @Override
    public Customer find(Customer customer) {
        Customer customerIn = customers.get(customer.getId());
        if (customerIn == null) {
            throw new CustomerNotFoundException();
        }
        return customerIn;
    }

    @Override
    public List<Customer> findAll() {
        List < Customer> result = new ArrayList<>();
        Iterator<Map.Entry<Long, Customer>> itr = customers.entrySet().iterator();
        for (Map.Entry<Long, Customer> entry : customers.entrySet()) {
            Customer value = entry.getValue();
            result.add(value);
        }
        return result;
    }


    @Override
    public boolean exists(Customer customer) {
        return customers.containsKey(customer.getId());
    }
}
