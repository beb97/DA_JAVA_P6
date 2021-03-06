package com.ocr.P6.controller;

import com.ocr.P6.dao.UserDao;
import com.ocr.P6.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    //Récupérer la liste des users
    @RequestMapping(value = "/users")
    public MappingJacksonValue listeProduits() {

        Iterable<User> users = userDao.findAll();
        MappingJacksonValue usersFiltres = new MappingJacksonValue(users);
        return usersFiltres;

    }

    @RequestMapping(value = "/user/{id}")
    public MappingJacksonValue findUser(@PathVariable Long id) {

        Optional<User> user = userDao.findById(id);
        MappingJacksonValue userFiltre= new MappingJacksonValue(user);
        return userFiltre;

    }

}
