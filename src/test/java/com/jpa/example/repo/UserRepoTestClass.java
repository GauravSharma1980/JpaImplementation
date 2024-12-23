package com.jpa.example.repo;


import com.jpa.example.entity.Laptop;
import com.jpa.example.entity.User;
import com.jpa.example.repository.LaptopRepository;
import com.jpa.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UserRepoTestClass {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private LaptopRepository laptopRepository;
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

    @Test
    public void testCount(){
        int totalUsersWithSameEmail = userRepository.countByEmail("gauravrsharmamca@yahoo.com");
        System.out.println(totalUsersWithSameEmail +"are there will same email id ");
    }

    @Test
    public void repoTest2(){
        List<User> user = userRepository.getUserByCountry("Bharat");
        user.forEach(usr -> System.out.println("name country"+usr.getName()));
    }

    @Test
    public void testSaveLaptopWithUser(){
        User user = userRepository.findById(122).get();
        Laptop laptop = new Laptop();
        laptop.setModel("Dell");
        laptop.setAbout("dell about");
        laptop.setUser(user);
        user.setLaptop(laptop);
        laptopRepository.save(laptop);
        userRepository.save(user);
        //laptopRepository.save(laptop);
    }

    @Test
    public void getUserFromLaptop(){
        Laptop laptop = laptopRepository.findById(1).get();
        User user = laptop.getUser();
        System.out.println("the user belongs to laptop id 1 is "+user.getName());
        Laptop laptop1 = user.getLaptop();
        System.out.println("the laptop belongs to Gaurav is "+laptop1.getId());
    }
}
