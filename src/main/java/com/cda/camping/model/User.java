package com.cda.camping.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @Column(name="id_user")
    @GeneratedValue(strategy= GenerationType.IDENTITY) 
    private Integer id;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    @Column(name="roles")
    private String roles;
}


