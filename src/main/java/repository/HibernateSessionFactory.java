package repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;


@Component
public class HibernateSessionFactory {
    private SessionFactory sessionFactory;

    public HibernateSessionFactory() {
        try {
            sessionFactory = new Configuration()
                    .configure()
                    .buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }


    public Session getSession(){
        return sessionFactory.openSession();
    }

    public void close(){
        sessionFactory.close();
    }

}
