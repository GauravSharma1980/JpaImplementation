package com.jpa.example.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jpa_category")
public class Category {

 @Id
 private int categoryId;
 private String categoryName;

 @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
 private List<Product> product;

}
