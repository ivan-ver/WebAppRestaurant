package repository.HibernateSessionFactory;

import model.AbstractBaseEntity;
import model.Person;
import model.Restaurant;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import repository.RepositoryRest;

import java.util.List;

@Repository
public class SessionFactoryRestaurantRepo implements RepositoryRest {
    private static final Logger log = Logger.getLogger(SessionFactoryRestaurantRepo.class);

    private final HibernateSessionFactory hsf;

    @Autowired
    public SessionFactoryRestaurantRepo(@Qualifier(value = "hsf") HibernateSessionFactory hsf) {
        this.hsf = hsf;
    }

    @Override
    public List<Restaurant> getAll() {
        Session session = hsf.getSession();
        List<Restaurant> restaurants = null;
        try {
            session.beginTransaction();
            restaurants = session.createQuery("FROM Restaurant").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.flush();
        session.close();
        return restaurants;
    }

    @Override
    public Restaurant getByID(Integer id) {
        Session session = hsf.getSession();
        Restaurant restaurant;
        Transaction tx = session.beginTransaction();

        restaurant = session.get(Restaurant.class, id);
        tx.commit();
        session.close();
        return restaurant;
    }

    @Override
    public void saveOrUpdate(AbstractBaseEntity o) {
        Session session = hsf.getSession();
        Transaction tx = session.beginTransaction();
        Restaurant r = (Restaurant) o;
        session.saveOrUpdate(r);
        tx.commit();
        session.close();
        log.info("Restaurant ID"+o.getId() + " was saved");
    }

    @Override
    public void delete(Integer id) {
        Session session = hsf.getSession();
        Transaction tx = session.beginTransaction();
        session.delete(session.load(Restaurant.class,id));
        tx.commit();
        session.close();
        log.info("Restaurant ID"+ id + " was deleted");
    }



}
