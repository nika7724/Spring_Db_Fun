package com.spring_boot.spring_db_fun.repositrory;

import com.spring_boot.spring_db_fun.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//the class provides the mechanism for storage, retrieval, update, delete and serach oepration an objects @repository
@Repository //will implement the CrudRepository
public class UserRepo {

    //dependency injection of JdbcTemplate to run SQL-queries
    @Autowired
    private JdbcTemplate template;

    //retrieve the user id - user name - & favorite teacher from "users" table
    public List<User> fetchAll() { //read only
        String sql = "SELECT userID, userName, favTeacher from users";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);//Java beans Pojo(basic object), mapping rows of a ResultSet on a per-row basis
        return template.query(sql, rowMapper);
            }

    //add a new user with id(auto-increments) - user name - password - & favorite teacher
    public User addUser(User user) {
String sql="INSERT INTO users (userName, password, favTeacher) values (?,?,?)";
template.update(sql, user.getUserName(), user.getPassword(), user.getFavTeacher());
        return null;
    }
//find and show user infomation via user's id
    public User findUserById (int id) { //read only
String sql ="SELECT userID, userName, favTeacher FROM users WHERE userID =?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);//Java beans Pojo(basic object),mapping rows of a ResultSet on a per-row basis
User user = template.queryForObject(sql, rowMapper, id); //provide SQL and extract results
        return user;
    }

    //delete a user via user id
  public Boolean deleteUser(int id) {
String sql = "DELETE FROM users WHERE userID =?";
        return template.update(sql, id) >0;
    }

    //find and edit a user's information via user's id
    public User updateUser(int id, User user) {
String sql = "UPDATE users SET userName = ?, favTeacher =? WHERE userID =?";
template.update(sql, user.getUserName(), user.getFavTeacher(), user.getUserID());
       return null;
    }
}
