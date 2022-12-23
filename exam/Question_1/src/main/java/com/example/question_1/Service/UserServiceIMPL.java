package com.example.question_1.Service;

import com.example.question_1.Exception.UserException;
import com.example.question_1.Model.User;
import com.example.question_1.Model.UserDto;
import com.example.question_1.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceIMPL implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserDto> getUser(String category) throws UserException {
        List<User> listOfUser = userDao.getAllByCategory(category);

        List<UserDto> ans = new ArrayList<>();

        for(User user : listOfUser) {
            UserDto userDto = new UserDto(user.getTitle(), user.getDescription());
            ans.add(userDto);
        }

        if(ans.size()>0) {
            return ans;
        } else {
            throw new UserException("No Users present with the given category");
        }

    }

    @Override
    public User saveUser(User user) throws UserException {
        Optional<User> user1 = userDao.findById(user.getTitle());

        if(user1.isEmpty()) {
            userDao.save(user);
            return user;
        } else {
            throw new UserException("User already present in the database");
        }
    }
}
