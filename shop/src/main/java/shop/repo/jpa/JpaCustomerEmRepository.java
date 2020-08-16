package shop.repo.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.exceptions.DuplicateCustomerException;
import shop.model.Customer;
import shop.repo.CustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("jpaCustomerEmRepository")
public class JpaCustomerEmRepository implements CustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public void create(Customer customer) {
        if (exists(customer)) {
            throw new DuplicateCustomerException();
        }
        entityManager.merge(customer);
    }

    @Override
    @Transactional
    public void remove(Customer customerIn) {
        Customer customer = entityManager.find(Customer.class, customerIn);
        entityManager.remove(customer);
    }

    @Override
    @Transactional
    public void remove(long id) {
        Customer customer = entityManager.find(Customer.class, id);
        entityManager.remove(customer);
    }

    @Override
    public Customer find(Customer customer) {
        return entityManager.find(Customer.class, customer.getId());
    }


    @Override
    public boolean exists(Customer customerIn) {
        Customer customer = entityManager.find(Customer.class, customerIn.getId());
        if (customer != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager
                .createQuery("select customer from Customer customer", Customer.class);
        return query.getResultList();
    }
}
