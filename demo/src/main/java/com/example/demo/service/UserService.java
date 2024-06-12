package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.enums.Badge;
import com.example.demo.exceptions.InvalidScoreException;
import com.example.demo.exceptions.UserAlreadyExistException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        Sort sort = Sort.by(Sort.Order.asc("Score"));
        return userRepository.findAll(sort);
    }

    @Override
    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException(userId));
    }

    @Override
    public User addUserToContest(Long userId, String userName) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            throw new UserAlreadyExistException(userId);
        }

        User newUser = new User(userId, userName);
        userRepository.save(newUser);
        return newUser;
    }

    @Override
    public User updateUserScore(Long userId, Integer score) {
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("UserNotFound"));
        if(score > 100 || score< 0){
            throw new InvalidScoreException(score);
        }
        user.setScore(score);
        updateBadge(user);
        return null;
    }

    private void updateBadge(User user){
        Set< Badge> badges = new HashSet<>();
        if(user.getScore()>=1){
            badges.add(Badge.Code_Ninja);
        }
        if(user.getScore()>=30){
            badges.add(Badge.Code_Champ);
        }if(user.getScore()>=60){
            badges.add(Badge.Code_Master);
        }
        user.setBadges(badges);
    }

    @Override
    public User removeUserFromContest(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("UserNotFound"));
        userRepository.delete(user);
        return null;
    }
}
