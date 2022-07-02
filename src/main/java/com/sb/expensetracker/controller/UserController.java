package com.sb.expensetracker.controller;

import com.sb.expensetracker.entity.User;
import com.sb.expensetracker.service.UserService;
import com.sb.expensetracker.util.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //crerate user
    @PostMapping(value = "/regsiter")
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserDto userDto){
        log.info("regiser user method");
        return new ResponseEntity<User>(userService.registerUser(userDto), HttpStatus.CREATED);
    }

    //GETuSER
    @GetMapping(value = "/user")
    public ResponseEntity<User> getUser(@RequestParam Long id){
        log.info("getUser method");
        return new ResponseEntity<User>(userService.getUser(id),HttpStatus.FOUND);
    }

    //update user
    @PutMapping(value = "/user")
    public ResponseEntity<User> updateUser(@Valid UserDto userDto, @RequestParam Long id){
        log.info("updateUser method");
        return new ResponseEntity<User>(userService.updateUser(id, userDto),HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/user")
    public ResponseEntity<String> deleteUser(@RequestParam Long id){
        log.info("deleteUser method");
        return new ResponseEntity<String>(userService.deleteUser(id),HttpStatus.NO_CONTENT);
    }
    //check
    @GetMapping("/user")
    private String check(){
        return "hi user controller working fine!";
    }
}
