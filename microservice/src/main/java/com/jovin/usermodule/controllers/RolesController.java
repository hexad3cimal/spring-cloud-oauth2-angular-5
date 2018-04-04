package com.jovin.usermodule.controllers;

import com.jovin.usermodule.repository.RolesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hexad3cimal on 7/3/18.
 */

@RestController
@RequestMapping("/roles/")
public class RolesController {

    @Autowired
    private RolesDao rolesDao;



    @PreAuthorize("hasAuthority('TUTOR')")
    @GetMapping("/listall")
    public ResponseEntity getAllRoles()throws Exception{

        return new ResponseEntity(rolesDao.listAllRoles(), HttpStatus.OK);
    }
}
