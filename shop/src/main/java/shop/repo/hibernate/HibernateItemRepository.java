package shop.repo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.model.Item;
import shop.repo.ItemRepository;

import java.util.List;

@Repository
@Transactional
public class HibernateItemRepository implements ItemRepository {


    private final SessionFactory sessionFactory;

    public HibernateItemRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Item item) {
        Session session = sessionFactory.getCurrentSession();
        session.save(item);
    }

    @Override
    public void remove(Item item) {

    }

    @Override
    public void remove(long id) {

    }

    @Override
    public Item find(Item item) {
        return null;
    }

    @Override
    public boolean exists(Item item) {
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Item> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Product", Item.class).list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Item> findAllWithCost() {
        return  sessionFactory
                .getCurrentSession()
                .getNamedQuery("Item.findAllWithCost")
                .list();
    }
}
