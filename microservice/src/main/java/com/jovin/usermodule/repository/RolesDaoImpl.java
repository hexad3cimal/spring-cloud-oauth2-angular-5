package com.jovin.usermodule.repository;

import com.usermodule.models.Roles;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hexad3cimal on 7/3/18.
 */

@Repository("RolesDao")
@Transactional
public class RolesDaoImpl implements RolesDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Roles> listAllRoles() throws Exception {
        return sessionFactory.getCurrentSession()
                .createCriteria(Roles.class)
                .list();
    }
}
