package com.jpa.example.repository;

import com.jpa.example.entity.User;
import org.hibernate.annotations.DialectOverride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    //defining query methods

    @Query(value = "select * from jpa_user",nativeQuery = true)
    public List<User> getUser();

    @Query(value = "select * from jpa_user where email =:email",nativeQuery = true)
    public List<User> getUsersByEmail(@Param("email") String email);

    @NativeQuery("select * from jpa_user where email =:email and name =:name")
    public List<User> getUserByEmailAndName(@Param("name")String name,@Param("email") String email);

    // we have to use the hql for independence of db
    // in which we can use the entity classes names
    // by using native = false


    @Query("select u from User u where u.email =:email and u.name =:name")
    public List<User> getUserByHql(@Param("email") String email, @Param("name") String name);


    @Query("select u from User u where u.address.country =:country")
    public List<User> getUserByCountry(@Param("country") String country);

}
