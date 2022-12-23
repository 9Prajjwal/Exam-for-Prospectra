package com.example.question_1.Controller;

import com.example.question_1.Exception.UserException;
import com.example.question_1.Model.User;
import com.example.question_1.Model.UserDto;
import com.example.question_1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("https://api.publicapis.org/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getList/{category}/")
    public ResponseEntity<List<UserDto>> getUserList(@PathVariable ("category") String category) throws UserException {

        List<UserDto> userDtoList = userService.getUser(category);

        return new ResponseEntity<List<UserDto>> (userDtoList, HttpStatus.FOUND);
    }

    @PostMapping("save/")
    public ResponseEntity<User> saveUserController(@RequestBody User user) throws UserException {

        User user1 = userService.saveUser(user);

        return new ResponseEntity<User>(user1,HttpStatus.CREATED);
    }
}
