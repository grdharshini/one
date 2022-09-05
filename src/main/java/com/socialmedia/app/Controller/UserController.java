package com.socialmedia.app.Controller;

import com.socialmedia.app.DTO.UserDTO;
import com.socialmedia.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ArrayList<UserDTO> getAllUser(){
        return userService.getAllUsers();
    }

    @GetMapping("/getDetails/{user_id}")
    public UserDTO getUserById(@PathVariable ("user_id") Integer user_id){
        return userService.getUserById(user_id);
    }

    @PostMapping("/postDetails")
    public UserDTO createUserDetails(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

}
