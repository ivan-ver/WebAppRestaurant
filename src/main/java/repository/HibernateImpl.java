package repository;

import model.Users;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public class HibernateImpl implements RepositoryRest{
    private SessionFactory sessionFactory;

    public HibernateImpl() {
        try {
            sessionFactory = new Configuration()
                    .configure()
                    .buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    private Session getSession(){
        return sessionFactory.openSession();
    }

    @Override
    public List<?> getAll() {
        Session session = getSession();
        List<Users> allUsers;
        session.beginTransaction();
        allUsers = session.createQuery("from Users ").list();
        session.close();
        close();
        return allUsers;
    }

    private void close(){
        sessionFactory.close();
    }

}
