package com.example.question_1.Repository;

import com.example.question_1.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,String> {

    public List<User> getAllByCategory(String category);
}
