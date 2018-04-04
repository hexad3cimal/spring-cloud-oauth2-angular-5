package com.jovin.webapp.auth.services;


import com.jovin.webapp.auth.models.Users;

/**
 * Created by hexad3cimal on 6/3/18.
 */
public interface UserService{

    Users getByEmail(String email)throws Exception;

}
