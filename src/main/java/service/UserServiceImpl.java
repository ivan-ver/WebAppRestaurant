package service;

import model.AbstractBaseEntity;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.entityConnection.RepositoryRest;

import java.util.List;
@Service
public class UserServiceImpl implements ServiceRest {


    @Override
    public List<?> getAll() {
        return null;
    }

    @Override
    public AbstractBaseEntity getByID(Integer id) {
        return null;
    }

    @Override
    public void saveOrUpdate(AbstractBaseEntity o) {

    }

    @Override
    public void delete(Integer id) {

    }


}
