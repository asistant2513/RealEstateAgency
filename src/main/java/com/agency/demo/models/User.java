package com.agency.demo.models;

import com.agency.demo.enums.UserRole;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    //  Private Section
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "pnumber")
    private String phoneNumber;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name = "pwd")
    private String password;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name="role")
    @Enumerated(EnumType.ORDINAL)
    private UserRole role;

    //End of Private section

    public User(){

    }

    public User(String phoneNumber,
                String password,
                String name,
                String surname,
                UserRole role) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.registrationDate = LocalDate.now();
        this.role = role;
    }

    // Getters And Setters section
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    //End of Getters And Setters section
}
