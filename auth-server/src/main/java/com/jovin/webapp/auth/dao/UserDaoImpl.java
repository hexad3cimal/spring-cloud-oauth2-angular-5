package com.jovin.webapp.auth.dao;

import com.jovin.webapp.auth.models.Users;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by hexad3cimal on 6/3/18.
 */

@Repository("UserDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public Users getByEmail(String email) throws Exception {
        return (Users)sessionFactory.getCurrentSession()
                .createCriteria(Users.class)
                .setFetchMode("userRoleses", FetchMode.JOIN)
                .add(Restrictions.eq("userCode",email)).uniqueResult();
    }


}
