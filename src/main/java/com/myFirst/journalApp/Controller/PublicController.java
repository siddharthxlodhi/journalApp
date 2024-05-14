package com.myFirst.journalApp.Controller;

import com.myFirst.journalApp.entity.User;
import com.myFirst.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        userService.saveNewUser(user);
        return user;
    }
}
