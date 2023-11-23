package com.example.springapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import com.example.springapp.model.Student;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Team {

    @Id
    @GeneratedValue
    private long id;
    private String teamName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}

/*
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "postgresql")
    @SequenceGenerator(name="postgresql", sequenceName = "address_seq", allocationSize = 1)
    long id;
    private String teamName;
    @JsonIgnoreProperties("teamList") //THIS IS A STOP CONDITION.
    @ManyToMany(mappedBy = "teamList", cascade = CascadeType.MERGE)  //THIS THING WILL TRY TO ADD TO AN EXISTING TEAM. \
                                                                     // PERSIST WILL CREATE NEW ONE TO EVERY NEW STUDENT
    private List<Student> studentList = new ArrayList<Student>();
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(Student student){
        studentList.add(student);
    }
}
*/
