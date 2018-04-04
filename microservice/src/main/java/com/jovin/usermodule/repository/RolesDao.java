package com.jovin.usermodule.repository;

import com.usermodule.models.Roles;

import java.util.List;

/**
 * Created by hexad3cimal on 7/3/18.
 */
public interface RolesDao {
    List<Roles> listAllRoles()throws Exception;
}
