package repository;

import model.AbstractBaseEntity;

import java.util.List;

public interface RepositoryRest<T extends AbstractBaseEntity> {
    List<T> getAll();
    T getByID(Integer id);
    void saveOrUpdate(T o);
    void delete(Integer id);
}
