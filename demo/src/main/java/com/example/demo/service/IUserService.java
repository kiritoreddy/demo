package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface IUserService {
    public List<User> getUsers();

    public User getUser(Long userId);

    public User addUserToContest(Long userId, String userName);

    public User updateUserScore(Long userId, Integer score);

    public User removeUserFromContest(Long userId);
}
