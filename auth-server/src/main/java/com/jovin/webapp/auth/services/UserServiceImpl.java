package com.jovin.webapp.auth.services;


import com.jovin.webapp.auth.dao.UserDao;
import com.jovin.webapp.auth.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hexad3cimal on 6/3/18.
 */

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public Users getByEmail(String email) throws Exception {
        return userDao.getByEmail(email);
    }
}
