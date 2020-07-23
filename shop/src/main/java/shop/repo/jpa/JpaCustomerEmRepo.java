package shop.repo.jpa;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.model.Customer;
import shop.repo.CustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("jpaCustomerEm")
public class JpaCustomerEmRepo implements CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Customer add(Customer customer) {
        return entityManager.merge(customer);
    }


    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager
                .createQuery("select cu from Customer cu", Customer.class);

        return query.getResultList();
    }

    @Override
    public void remove(long id) {

    }

    @Override
    public Customer findOne(long id) {
        return null;
    }
}
