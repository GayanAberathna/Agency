package com.sample.mybatisdemo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
@Entity
@Getter
@Setter
public class User
{

    private Integer userId;
    private String emailId;
    private String password;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "User [userId=" + userId + ", emailId=" + emailId
                + ", password=" + password + ", firstName=" + firstName
                + ", lastName=" + lastName + ']';
    }

}
