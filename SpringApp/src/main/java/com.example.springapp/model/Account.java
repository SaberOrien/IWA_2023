package com.example.springapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.*;



@Entity
public class Account {

    @Id
    @GeneratedValue
    private long id;
    private String accountName;

    @JsonIgnore
    // Commented out due to simplify http requests sent from angular app
//    @OneToOne(mappedBy = "account")
//    private Student student;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }


    // Commented out due to simplify http requests sent from angular app
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }

}



/*
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postgresql")
    @SequenceGenerator(name="postgresql", sequenceName = "account_seq", allocationSize = 1)
    private long id;
    private String accountName;
    private String accountType;

    @JsonIgnore
    @OneToOne(mappedBy = "account")
    private Student student;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
*/
