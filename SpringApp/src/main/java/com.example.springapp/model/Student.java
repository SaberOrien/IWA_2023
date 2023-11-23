package com.example.springapp.model;

import com.example.springapp.model.Address;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postgresql")
    @SequenceGenerator(name="postgresql", sequenceName = "student_seq", allocationSize = 1)
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String telephone;

    // Commented out due to simplify http requests sent from angular app
//    @OneToOne(cascade = CascadeType.ALL)
//    private Account account;
//
//    @JsonBackReference
//    @ManyToOne(cascade = CascadeType.MERGE)
//    private Address address;
//
//    @ManyToMany(cascade = CascadeType.PERSIST)
//    private List<Team> teamList;
    // Commented out due to simplify http requests sent from angular app

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    // Commented out due to simplify http requests sent from angular app
//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
//
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//
//    public List<Team> getTeamList() {
//        return teamList;
//    }
//
//    public void setTeamList(List<Team> teamList) {
//        this.teamList = teamList;
//    }
    // Commented out due to simplify http requests sent from angular app

}




/*
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postgresql")
    @SequenceGenerator(name="postgresql", sequenceName = "student_seq", allocationSize = 1)
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String telephone;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Account account;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.MERGE)
    private Address address;

    @JsonIgnoreProperties("studentList")
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="student_team_list", joinColumns = @JoinColumn(name="student_id"), inverseJoinColumns = @JoinColumn(name = "team_list_id"))
    private List<Team> teamList = new ArrayList<Team>();
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getTelephone(){
        return telephone;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Team> getTeamList() {
        return teamList;
    }
}
 */
