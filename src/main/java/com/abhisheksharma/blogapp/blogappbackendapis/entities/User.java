package com.abhisheksharma.blogapp.blogappbackendapis.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="user_name", nullable = false, length=100)
    private String name;

    @Column(nullable = false, length=100)
    private String email;

    @Column(nullable = false, length=100)
    private String password;

    @Column(nullable = false, length=100)
    private String about;

}
