package com.jpa.example.repo;


import com.jpa.example.entity.User;
import com.jpa.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UserRepoTestClass {

    @Autowired
    UserRepository userRepository;
    @Test
    public void repoTest(){
        Optional<User> user  = userRepository.findByEmail("g@gmail.com");
        user.ifPresentOrElse(user1 -> {
            System.out.println("userId"+user1.getUserId());
            System.out.println("name"+user1.getName());
            System.out.println("age"+user1.getAge());
            System.out.println("address country"+user1.getAddress().getCountry());
            System.out.println("address street"+user1.getAddress().getStreet());
            System.out.println("address zip"+user1.getAddress().getZip());
        },() -> {
            System.out.println("user does not found");
        });
    }
}
