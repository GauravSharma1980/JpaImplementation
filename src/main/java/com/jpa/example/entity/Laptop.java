package com.jpa.example.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "jpa_laptop")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private String about;

    @OneToOne
    private User user;




}
