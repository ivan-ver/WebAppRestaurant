package service;

import model.AbstractBaseEntity;
import org.springframework.stereotype.Service;

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
