package com.example.bits.model;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "courseId", nullable = false, unique = true)
    private  String courseId;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "sem1", nullable = false)
    private boolean sem1;

    @Column(name = "sem2", nullable = false)
    private boolean sem2;

    @Column(name = "sem3", nullable = false)
    private boolean sem3;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSem1() {
        return sem1;
    }

    public void setSem1(boolean sem1) {
        this.sem1 = sem1;
    }

    public boolean isSem2() {
        return sem2;
    }

    public void setSem2(boolean sem2) {
        this.sem2 = sem2;
    }

    public boolean isSem3() {
        return sem3;
    }

    public void setSem3(boolean sem3) {
        this.sem3 = sem3;
    }
}
