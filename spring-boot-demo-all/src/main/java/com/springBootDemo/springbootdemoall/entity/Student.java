package com.springBootDemo.springbootdemoall.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {


    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean active;
    private String remark;



}
