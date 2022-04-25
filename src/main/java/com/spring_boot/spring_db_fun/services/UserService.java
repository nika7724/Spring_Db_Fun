package com.spring_boot.spring_db_fun.services;

import com.spring_boot.spring_db_fun.model.User;
import com.spring_boot.spring_db_fun.repositrory.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*resides in the service layer @Service
 * typically business logic is placed here*/
@Service
public class UserService {

    @Autowired //back door way to create the object, Java spring create an object behind the scene
    private UserRepo userRepo;//

    public List<User> fetchAll() { //read

        return userRepo.fetchAll();
    }

    public User addUser(User user) {

        return userRepo.addUser(user);
    }

    public User findUserById (int id) { //read

        return userRepo.findUserById(id);
    }

    public Boolean deleteUser(int id) {

        return userRepo.deleteUser(id);
    }

    public User updateUser(int id, User user) {

        return userRepo.updateUser(id, user);
    }
}
