package com.mazhar.security.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "secret_key")
@Data
public class SecretKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String key;
}
