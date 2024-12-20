package com.jpa.example.entity;

import com.jpa.example.dto.UserType;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="jpa_user")
public class User {

    @Id
    @Column(name="jpa_user_id")
    private int userId;
    @Column(name="jpa_user_name",nullable = false)
    private String name;
    private String email;
    private int age;
    private boolean isActive;

    @Transient
    private String  extraInformation;

    @Enumerated(EnumType.STRING)
    private UserType userType = UserType.STUDENT;




}
