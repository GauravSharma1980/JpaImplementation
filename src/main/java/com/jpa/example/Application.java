package com.jpa.example;

import com.jpa.example.dto.UserType;
import com.jpa.example.entity.User;
import com.jpa.example.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.debug("going to save user record..");
		User user = new User();
		user.setUserId(124);
		user.setActive(true);
		user.setName("Gaurav");
		user.setUserType(UserType.STUDENT);
		user.setEmail("gauravrsharmamca@yahoo.com");
		User save = userRepository.save(user);
		log.debug("user has been saved successfully.....");

		System.out.println("user using findAll...........");
		List<User> userList = userRepository.findAll();
		userList.forEach(user1 -> {
			System.out.println(user1.getName());
		});

		System.out.println("using findByName.....................");
		List<User> allUsers = userRepository.findByName("gaurav");
		allUsers.forEach(user2->{
			System.out.println(user2.getAge());
		});


	}
}
