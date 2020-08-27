package shop.repo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.model.Cost;
import shop.repo.CostRepository;

import java.util.List;

@Repository
@Transactional
public class HibernateCostRepository implements CostRepository{

    private final SessionFactory sessionFactory;

    public HibernateCostRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    @Override
    public void create(Cost cost) {
        Session session = sessionFactory.getCurrentSession();
        session.save(cost);
    }

    @Override
    public void remove(Cost cost) {

    }

    @Override
    public void remove(long id) {

    }

    @Override
    public Cost find(Cost cost) {
        return null;
    }

    @Override
    public boolean exists(Cost cost) {
        return false;
    }

    @Override
    public List<Cost> findAll() {
        return null;
    }
}
