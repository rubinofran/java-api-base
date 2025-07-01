package com.example.api_base.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@Getter 
@Setter
public class UserModel {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(unique = true, nullable = false)
    private Long id;
    
    private String name;

    private String email;

    private Integer priority;

}
