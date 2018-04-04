package com.jovin.usermodule.controllers;

import com.jovin.usermodule.mappers.UserMappers;
import com.jovin.usermodule.utils.TimeUtil;
import com.jovin.usermodule.dto.UserMapper;
import com.usermodule.models.Users;
import com.jovin.usermodule.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TimeUtil timeUtil;

    private UserMappers userMappers = new UserMappers();

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody Users user)throws Exception{
        return new ResponseEntity("success ", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody UserMapper user)throws Exception{
        return new ResponseEntity("success ", HttpStatus.OK);
    }

    @GetMapping("/get/{data}")
    public ResponseEntity getEndPoint(@PathVariable String data)throws Exception{

        String[] getData = data.split("=");
        if(Objects.nonNull(getData)){

            if(getData[0].equalsIgnoreCase("all"))
                return new ResponseEntity(userService.getAllUsers(),HttpStatus.OK);
            if(getData[0].equalsIgnoreCase("id"))
                return new ResponseEntity(userService.getById(getData[1]),HttpStatus.OK);
            if(getData[0].equalsIgnoreCase("tutor"))
                return new ResponseEntity(userMappers
                        .userToTutor(userService.getTutorDetailsById(getData[1])),HttpStatus.OK);
        }

        return new ResponseEntity(new ArrayList<>(),HttpStatus.OK);
    }


}
