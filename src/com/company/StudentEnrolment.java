package com.company;
import java.util.ArrayList;

public class StudentEnrolment{
    Student student;
    Course course;
    String semester;

    public StudentEnrolment(Student student, Course course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "StudentEnrolment{" +
                "student=" + student +
                ", course=" + course +
                ", semester='" + semester + '\'' +
                '}';
    }
}
