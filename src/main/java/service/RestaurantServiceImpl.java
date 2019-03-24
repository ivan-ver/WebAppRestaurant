package service;

import model.AbstractBaseEntity;

import model.Person;
import model.Restaurant;
import model.RestaurantTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.HibernateSessionFactory.SessionFactoryRestaurantRepo;
import util.Util;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RestaurantServiceImpl implements ServiceRest {
    private final SessionFactoryRestaurantRepo repository;
    private final Util util;

    @Autowired
    public RestaurantServiceImpl(SessionFactoryRestaurantRepo repository, Util util) {
        this.repository = repository;
        this.util = util;
    }


    @Override
    @Transactional
    public List<RestaurantTo> getAll() {
        return util.CreateRestaurantToList(repository.getAll());
    }

    @Override
    @Transactional
    public Restaurant getByID(Integer id) {
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
