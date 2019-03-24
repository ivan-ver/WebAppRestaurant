package repository.HibernateSessionFactory;

import model.AbstractBaseEntity;
import model.Dish;
import model.Person;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import repository.RepositoryRest;

import java.util.List;

@Repository
public class SessionFactoryDishRepo implements RepositoryRest {
    private static final Logger log = Logger.getLogger(SessionFactoryRestaurantRepo.class);

    private final HibernateSessionFactory hsf;

    @Autowired
    public SessionFactoryDishRepo(@Qualifier(value = "hsf") HibernateSessionFactory hsf) {
        this.hsf = hsf;
    }

    @Override
    public List<Dish> getAll() {
        Session session = hsf.getSession();
        session.beginTransaction();
        List<Dish> restaurants;
        restaurants = session.createQuery("FROM Dish").list();
        session.flush();
        session.close();
        return restaurants;
    }

    @Override
    public Dish getByID(Integer id) {
        Session session = hsf.getSession();
        Transaction tx = session.beginTransaction();
        Dish dish;
        dish = session.get(Dish.class, id);
        tx.commit();
        session.close();
        return dish;
    }

    @Override
    public void saveOrUpdate(AbstractBaseEntity o) {
        Session session = hsf.getSession();
        Transaction tx = session.beginTransaction();
        Dish d = (Dish)o;
        session.saveOrUpdate(d);
        tx.commit();
        session.close();
        log.info("Dish ID"+o.getId() + " was saved");
    }

    @Override
    public void delete(Integer id) {
        Session session = hsf.getSession();
        Transaction tx = session.beginTransaction();
        session.delete(session.load(Dish.class,id));
        tx.commit();
        session.close();
        log.info("Dish ID" + id + " was saved");
    }



}
