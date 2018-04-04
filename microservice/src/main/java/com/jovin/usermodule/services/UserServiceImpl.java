package com.jovin.usermodule.services;

import com.usermodule.models.Users;
import com.jovin.usermodule.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hexad3cimal on 6/3/18.
 */

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<Users> getAllUsers() throws Exception {
        return userDao.getAllUsers();
    }

    @Override
    public Users getById(String id) throws Exception {
        return userDao.getById(id);
    }

    @Override
    public Users getTutorDetailsById(String id) throws Exception {
        return userDao.getTutorDetailsById(id);
    }



}
