package com.iccteams.iccteams.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Player {
    @Id
    @GeneratedValue
    private int id;
    private String name;
//    @DateTimeFormat(pattern = "dd-MM-yyyy")
//    private LocalDate DOB;
    private Double Age;
    private String role;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH})
    @JoinColumn(name = "country_id")
    private Country country;

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public LocalDate getDOB() {
//        return DOB;
//    }
//
//    public void setDOB(LocalDate DOB) {
//        this.DOB = DOB;
//    }

    public Double getAge() {
        return Age;
    }

    public void setAge(Double age) {
        Age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
