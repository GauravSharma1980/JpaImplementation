package com.jpa.example;

import com.jpa.example.dto.UserType;
import com.jpa.example.entity.Address;
import com.jpa.example.entity.User;
import com.jpa.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Test
	void getUserById() {
		User ouser = userRepository.findById(122).orElseThrow(() -> new RuntimeException("user not found"));
		System.out.println(ouser.getName());
	}

	@Test
	void setUser(){
		User user = new User();
		Address address = new Address();
		address.setCountry("Bharat");
		address.setZip("190");
		address.setStreet("Saraswati nagar");
		user.setUserType(UserType.STUDENT);
		user.setEmail("g@gmail.com");
		user.setName("Gaurav");
		user.setActive(true);
		user.setAge(19);
		user.setAddress(address);
		userRepository.save(user);

	}
}
