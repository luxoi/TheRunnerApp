package com.luxoi.therunnerapp.therunnerapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/getall")
    public ResponseEntity<List<UserModel>> getAllUsers() {
        List<UserModel> users = userService.findAll();
        return ResponseEntity.ok(users);
    }


    @PostMapping("/save")
    public UserModel createUser(@RequestBody UserModel user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable Long id){
        try{
            UserModel userModel = userService.findById(id);
            return ResponseEntity.ok(userModel);
        }catch (UserNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try {
            UserModel user = userService.findById(id);
            userService.deleteUser(user);
            return ResponseEntity.noContent().build();
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}