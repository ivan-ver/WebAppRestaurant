package service;

import model.AbstractBaseEntity;
import model.Person;

import java.util.List;

public interface ServiceRest <T extends AbstractBaseEntity> {
    List<?> getAll();
    T getByID(Integer id);
    void saveOrUpdate(T o);
    void delete(Integer id);
}
