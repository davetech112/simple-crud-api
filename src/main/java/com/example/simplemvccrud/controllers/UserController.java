package com.example.simplemvccrud.controllers;

import com.example.simplemvccrud.DTO.UserDTO;
import com.example.simplemvccrud.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.login(userDTO), HttpStatus.OK);
    }
    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signup(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.signup(userDTO), HttpStatus.OK);
    }
    @PostMapping("/{id}/update")
    public ResponseEntity<UserDTO> update(@PathVariable("id") Long id, @RequestBody UserDTO userDTO){

        return new ResponseEntity<>(userService.update(id), HttpStatus.OK);
    }
    @PostMapping("/{id}/delete")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        userService.delete( id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }
}
