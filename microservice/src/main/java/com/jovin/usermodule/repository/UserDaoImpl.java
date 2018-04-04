package com.jovin.usermodule.repository;

import com.usermodule.models.Users;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hexad3cimal on 6/3/18.
 */

@Repository("UserDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Users> getAllUsers() throws Exception {

        return sessionFactory.getCurrentSession()
                .createCriteria(Users.class)
                .setFetchMode("userDetailses", FetchMode.JOIN)
                .setFetchMode("userRoleses", FetchMode.JOIN)
                .list();
    }

    @Override
    public Users getById(String id) throws Exception {
        return (Users)sessionFactory.getCurrentSession()
                .createCriteria(Users.class)
                .setFetchMode("userDetailses", FetchMode.JOIN)
                .setFetchMode("userRoleses", FetchMode.JOIN)
                .add(Restrictions.eq("userId",id)).uniqueResult();
    }

    @Override
    public Users getTutorDetailsById(String id) throws Exception {
        return (Users)sessionFactory.getCurrentSession()
                .createCriteria(Users.class)
                .setFetchMode("userDetailses", FetchMode.JOIN)
                .setFetchMode("userRoleses", FetchMode.JOIN)
                .setFetchMode("tutorDayses", FetchMode.JOIN)
                .setFetchMode("tutorSubjectsForCreatedBy", FetchMode.JOIN)
                .setFetchMode("tutorSubjectsForUserCode", FetchMode.JOIN)
                .setFetchMode("studentTutorAssociationsForTutorId", FetchMode.JOIN)
                .setFetchMode("userEducations", FetchMode.JOIN)
                .setFetchMode("bookSessionsForTutorCode", FetchMode.JOIN)
                .setFetchMode("homeWorks", FetchMode.JOIN)
                .setFetchMode("bankAccounts", FetchMode.JOIN)
                .setFetchMode("tests", FetchMode.JOIN)
                .setFetchMode("announcements", FetchMode.JOIN)
                .setFetchMode("workExperiences", FetchMode.JOIN)
                .setFetchMode("studentDemosForTutorId", FetchMode.JOIN)
                .add(Restrictions.eq("userId",id)).uniqueResult();
    }
}
