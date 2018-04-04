package com.jovin.usermodule.services;

import com.usermodule.models.Users;

import java.util.List;

/**
 * Created by hexad3cimal on 6/3/18.
 */
public interface UserService{

    List<Users> getAllUsers()throws Exception;
    Users getById(String id)throws Exception;
    Users getTutorDetailsById(String id)throws Exception;

}
