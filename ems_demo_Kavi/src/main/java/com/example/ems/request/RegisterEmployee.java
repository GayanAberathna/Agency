package com.example.ems.request;

import javax.validation.constraints.NotNull;
import java.sql.Date;

public class RegisterEmployee {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String address;
    @NotNull
    private Date birthDay;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
