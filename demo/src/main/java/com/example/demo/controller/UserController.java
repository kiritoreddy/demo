package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.exceptions.InvalidScoreException;
import com.example.demo.exceptions.UserAlreadyExistException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    public static final String END_POINT = "/users";

    @Autowired
    private UserService userService;

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<String> handleUserAlreadyExistException(UserAlreadyExistException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(InvalidScoreException.class)
    public ResponseEntity<String> handleInvalidScoreException(InvalidScoreException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
            List<User> users = userService.getUsers();
            return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserWithId(@PathVariable Long id){
            User user = userService.getUser(id);
            return ResponseEntity.ok(user);
    }

    @PostMapping()
    public ResponseEntity<User> addUser(@RequestBody User newUser){
        User user = userService.addUserToContest(newUser.getId(),newUser.getUserName());
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> addScoreToUser(@PathVariable Long id, @RequestBody Map<String, Integer> requestBody){
        Integer score = requestBody.get("Score");
        User user = userService.updateUserScore(id,score);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.removeUserFromContest(id);
        return ResponseEntity.noContent().build();
    }


}
