package repository.HibernateSessionFactory;

import model.AbstractBaseEntity;
import model.Person;
import model.Restaurant;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import repository.RepositoryRest;

import java.util.List;

@Repository
public class SessionFactoryPersonRepo implements RepositoryRest {
    private final HibernateSessionFactory hsf;

    @Autowired
//    @Qualifier(value = "hsf")
    public SessionFactoryPersonRepo( HibernateSessionFactory hsf) {
        this.hsf = hsf;
    }

    @Override
    public List getAll() {
        Session session = hsf.getSession();
        List<Person> persons = null;
        try {
            session.beginTransaction();
            persons = session.createQuery("FROM Person ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.flush();
        session.close();
        return persons;
    }

    @Override
    public Person getByID(Integer id) {
        Session session = hsf.getSession();
        Transaction tx = session.beginTransaction();
        Person person;
        person = session.get(Person.class, id);
        tx.commit();
        session.close();
        return person;
    }

    @Override
    public void saveOrUpdate(AbstractBaseEntity o) {
        Session session = hsf.getSession();
        Transaction tx = session.beginTransaction();
        Person p = (Person) o;
        session.saveOrUpdate(p);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Integer id) {

    }

    public Person getByEmail(String email) {
        Session session = hsf.getSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("FROM Person WHERE email = :email");
        List list = query.setParameter("email",email).list();
        Person person = (Person) list.get(0);
        tx.commit();
        session.close();
        return person;
    }
}
