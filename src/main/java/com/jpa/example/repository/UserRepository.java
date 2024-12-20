package com.jpa.example.repository;

import com.jpa.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByName(String name);

    Optional<User> findByEmail(String email);

    List<User> findByNameAndEmail(String name,String email);
    List<User> findByNameOrEmail(String name,String email);

    int countByEmail(String email);

    boolean existsByEmail(String email);

    //will create a query with the 'like' query
    List<User> findByNameContaining(String nameKeyword);

    List<User> findByNameLike(String pattern);

    User findDistinctByEmail(String email);
}
