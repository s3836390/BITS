package com.company;

import java.util.ArrayList;

public interface StudentEnrolmentManager {
    public void add();
    public void printCourse(String studentId);
    public void update(String studentId);
    public void delete(String studentId);
    public StudentEnrolment getOne(String studentId, String courseId);
    public ArrayList<StudentEnrolment> getAll();
    public void printStudent(String courseId);
    public void printCourseSemester(String semester);
}
