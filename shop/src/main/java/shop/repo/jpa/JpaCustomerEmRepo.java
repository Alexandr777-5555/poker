package shop.repo.jpa;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.model.Customer;
import shop.repo.CustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("jpaCustomerEm")
public class JpaCustomerEmRepo implements CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    @Override
    public Customer add(Customer customer) {
        return entityManager.merge(customer);
    }


    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public void remove(long id) {

    }

    @Override
    public Customer findOne(long id) {
        return null;
    }
}
