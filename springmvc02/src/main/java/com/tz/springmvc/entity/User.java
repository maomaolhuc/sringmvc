package com.tz.springmvc.entity;

import lombok.Data;

@Data
public class User {

    private int id;

    private String username;

    private String password;

    private String email;

    private int age;

    private Address address;


}
