package shop.repo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import shop.model.Customer;
import shop.repo.CustomRepo;

import java.util.List;


@Transactional
public class HibernateCustomerRepo implements CustomRepo {

    private final SessionFactory sessionFactory;

    public HibernateCustomerRepo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Customer add(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(customer);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Customer", Customer.class).list();
    }

    @Override
    public void remove(long id) {
        Session session = sessionFactory.getCurrentSession();
        Customer  customer=session.get(Customer.class , id);
        session.delete(customer);
    }

    @Override
    public Customer findOne(long id) {
        return (Customer)
                this.sessionFactory.getCurrentSession().get(Customer.class, id);
    }


}
