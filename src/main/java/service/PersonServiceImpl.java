package service;

import model.AbstractBaseEntity;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.HibernateSessionFactory.SessionFactoryPersonRepo;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class PersonServiceImpl implements ServiceRest {

    private final SessionFactoryPersonRepo personRepo;

    @Autowired
    public PersonServiceImpl(SessionFactoryPersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @Override
    @Transactional
    public List<Person> getAll() {
        return personRepo.getAll();
    }

    @Override
    public Person getByID(Integer id) {
        return personRepo.getByID(id);
    }

    @Override
    public void saveOrUpdate(AbstractBaseEntity o) {
        personRepo.saveOrUpdate(o);
    }

    @Override
    public void delete(Integer id) {

    }

    public Person getByEmail(String email) {
        return personRepo.getByEmail(email);
    }


}
