package com.staxrt.tutorial.controller;

import com.staxrt.tutorial.model.Login;
import com.staxrt.tutorial.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class LoginController {


    @Autowired
    private LoginRepository loginRepository;

    @PostMapping("/createlogin")
    public Login createLogin(@Valid @RequestBody Login login){
        System.out.println(login.getUserName());
        return loginRepository.save(login);
    }
}
//{
//        "userName": "meghana",
//        "password": "123dfd",
//        "age": 2342
//}