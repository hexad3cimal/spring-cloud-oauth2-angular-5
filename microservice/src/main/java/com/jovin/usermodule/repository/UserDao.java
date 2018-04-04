package com.jovin.usermodule.repository;

import com.usermodule.models.Users;

import java.util.List;

/**
 * Created by hexad3cimal on 6/3/18.
 */
public interface UserDao {

    List<Users> getAllUsers()throws Exception;
    Users getById(String id)throws Exception;
    Users getTutorDetailsById(String id)throws Exception;

}
