package repository.HibernateSessionFactory;

import model.AbstractBaseEntity;
import model.Assessment;
import model.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repository.RepositoryRest;

import java.util.List;
@Repository
public class SessionFactoryAssessmentRepo implements RepositoryRest {

    private final HibernateSessionFactory hsf;

    @Autowired
    public SessionFactoryAssessmentRepo(HibernateSessionFactory hsf) {
        this.hsf = hsf;
    }

    @Override
    public List getAll() {
       return null;
    }

    @Override
    public Assessment getByID(Integer id) {
        Session session = hsf.getSession();
        Transaction tx = session.beginTransaction();
        Assessment assessment;
        assessment = session.get(Assessment.class, id);
        tx.commit();
        session.close();
        return assessment;
    }

    @Override
    public void saveOrUpdate(AbstractBaseEntity o) {
        Session session = hsf.getSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(o);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Integer id) {

    }

}
