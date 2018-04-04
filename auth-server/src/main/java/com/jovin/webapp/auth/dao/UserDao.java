package com.jovin.webapp.auth.dao;


import com.jovin.webapp.auth.models.Users;

/**
 * Created by hexad3cimal on 6/3/18.
 */
public interface UserDao {

    Users getByEmail(String email)throws Exception;

}
