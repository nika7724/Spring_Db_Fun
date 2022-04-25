package com.spring_boot.spring_db_fun.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/*entity class for table "users" @Entity
 * the attributes for User class
 * are to be the same as * the attributes
 * in the "users" table*/
@Entity
public class User {

    @Id //marks a feild in the model class User @Id, building a table
    private int userID;
    private String userName;
    private String password;
    private String favTeacher;

    public User() {

    }

    //getter methods for User
    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFavTeacher() {
        return favTeacher;
    }

    //setter methods for User

    public void setUserID(int userID) {

        this.userID = userID;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public void setFavTeacher(String favTeacher) {

        this.favTeacher = favTeacher;
    }
}
