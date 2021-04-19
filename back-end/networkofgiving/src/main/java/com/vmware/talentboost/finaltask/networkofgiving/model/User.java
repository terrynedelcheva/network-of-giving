package com.vmware.talentboost.finaltask.networkofgiving.model;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users"/*, uniqueConstraints = {
        @UniqueConstraint(columnNames = "username")
}*/)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    @Size(max = 20)
    private String username;

    @Column
    @NotBlank
    @Size(max = 20)
    private String password;

    @Column
    @NotBlank
    @Size(max = 120)
    private String firstName;

    @Column
    @NotBlank
    @Size(max = 120)
    private String lastName;

    @Column
    @NotBlank
    private int age;

    @Column
    private String gender;

    @Column
    private String location;

    public Long getId() {
        return this.id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }
}
