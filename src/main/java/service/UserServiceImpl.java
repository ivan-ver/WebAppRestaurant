package service;

import model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RepositoryRest;

import java.util.List;
@Service
public class UserServiceImpl implements ServiceRest {
    @Autowired
    private RepositoryRest repository;
    public List<Users> getAll(){
        return (List<Users>) repository.getAll();
    }
}
