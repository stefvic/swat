package com.swat.mercedes.fe.entities;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class User {
    @NotNull
    private Integer age;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
