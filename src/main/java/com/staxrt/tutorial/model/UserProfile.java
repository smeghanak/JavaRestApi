package com.staxrt.tutorial.model;

import javax.persistence.*;

@Entity
@Table(name = "UserProfiles")

public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_Name", nullable = false)
    private String userName;

    @Column(name = "phone_number", nullable = false)
    private long phoneNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name="address",nullable = false)
    private String address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
