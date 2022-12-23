package com.example.question_1.Service;

import com.example.question_1.Exception.UserException;
import com.example.question_1.Model.User;
import com.example.question_1.Model.UserDto;

import java.util.List;

public interface UserService {

    public List<UserDto> getUser(String category) throws UserException;
    public User saveUser(User user) throws UserException;
}
