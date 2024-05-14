package com.myFirst.journalApp.Controller;

import com.myFirst.journalApp.entity.User;
import com.myFirst.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userindb = userService.findByUsername(userName);
        userindb.setUserName(user.getUserName());
        userindb.setPassword(user.getPassword());
        userService.saveNewUser(userindb);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
