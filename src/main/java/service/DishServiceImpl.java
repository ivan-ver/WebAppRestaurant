package service;

import model.AbstractBaseEntity;
import model.Dish;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.HibernateSessionFactory.SessionFactoryDishRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DishServiceImpl implements ServiceRest {

    private final SessionFactoryDishRepo repository;

    @Autowired
    public DishServiceImpl(SessionFactoryDishRepo repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public List<Dish> getAll() {
        return repository.getAll();
    }

    @Override
    @Transactional
    public Dish getByID(Integer id) {
        return repository.getByID(id);
    }

    @Override
    @Transactional
    public void saveOrUpdate(AbstractBaseEntity o) {
        repository.saveOrUpdate(o);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        repository.delete(id);
    }

}
