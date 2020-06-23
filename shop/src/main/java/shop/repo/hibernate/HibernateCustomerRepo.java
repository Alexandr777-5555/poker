package shop.repo.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import shop.domain.Customer;
import shop.repo.CustomerRepository;

import java.util.List;


public class HibernateCustomerRepo implements CustomerRepository {


    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateCustomerRepo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Customer add(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public void remove(long id) {

    }

    @Override
    public Customer findOne(int id) {
        return null;
    }
}
