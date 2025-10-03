package com.example.student.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int theoryTestScores;
    private int practiceTestScores;

    @Column(name = "description")
    private String describe;

    private String evaluate;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    public Student() {}

    public Student(String name, int theoryTestScores, int practiceTestScores, String describe, String evaluate, School school) {
        this.name = name;
        this.theoryTestScores = theoryTestScores;
        this.practiceTestScores = practiceTestScores;
        this.describe = describe;
        this.evaluate = evaluate;
        this.school = school;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTheoryTestScores() {
        return theoryTestScores;
    }

    public void setTheoryTestScores(int theoryTestScores) {
        this.theoryTestScores = theoryTestScores;
    }

    public int getPracticeTestScores() {
        return practiceTestScores;
    }

    public void setPracticeTestScores(int practiceTestScores) {
        this.practiceTestScores = practiceTestScores;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
