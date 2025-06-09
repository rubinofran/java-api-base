package com.example.api_base.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
public class UserModel {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(unique = true, nullable = false) @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private Integer priority;

}
