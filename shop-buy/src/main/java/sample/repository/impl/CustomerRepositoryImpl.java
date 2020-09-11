package sample.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sample.model.Customer;
import sample.repository.CustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Customer save(Customer customer) {
        if (customer.getId() == null) {
            logger.info("insert new customer");
            em.persist(customer);
        } else {
            em.merge(customer);
            logger.info("update exists customer");
        }
        logger.info("customer saved with id :" + customer.getId());
        return customer;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        return em
                .createNamedQuery(Customer.FIND_ALL, Customer.class)
                .getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> findAllWithPurchases() {
        List<Customer> customers=
                em.createNamedQuery(Customer.FIND_ALL_WITH_PURCHASES , Customer.class)
                        .getResultList();
        return customers;
    }



}
