package shop.repo.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import shop.model.Customer;
import shop.repo.CustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("jpaCustomer")
public class JpaCustomerRepo implements CustomerRepository {

    private final EntityManagerFactory entityManagerFactory;

    public JpaCustomerRepo(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Customer add(Customer customer) {

        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            Customer custom = manager.merge(customer);
            transaction.commit();
            return custom;
        } catch (RuntimeException ex) {
            transaction.rollback();
            throw ex;
        } finally {
            manager.close();
        }
    }

    @Override
    public List<Customer> findAll() {
        EntityManager manager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<Customer> query = manager
                    .createQuery("select customer from Customer customer", Customer.class);
            return query.getResultList();
        } finally {
            manager.close();
        }
    }

    @Override
    public void remove(long id) {

    }

    @Override
    public Customer findOne(long id) {
        return null;
    }


}
