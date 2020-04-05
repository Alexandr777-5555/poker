package ps.repository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ps.model.base.Player;

import java.util.List;

@Repository
public class HibernatePlayerRepo implements PlayerRepository {


    private SessionFactory sessionFactory;

    public HibernatePlayerRepo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int save(Player player) {

        return (int) sessionFactory
                .getCurrentSession()
                .save(player);
    }



    @Override
    public List<Player> findAll() {
        return
                sessionFactory
                        .getCurrentSession()
                        .createQuery("FROM Player")
                        .list();
    }

    @Override
    public List<Player> listForId(int id) {

        return sessionFactory
                .getCurrentSession()
                .createQuery("FROM Player WHERE id= "+id)
                .list();
    }


}

