package com.example.bits.service;

import com.example.bits.model.Course;
import com.example.bits.model.Student;
import com.example.bits.model.User;
import com.example.bits.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bits.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> optional = studentRepository.findById(id);
        Student student = null;
        if (optional.isPresent()){
            student = optional.get();
        } else {
            throw new RuntimeException("Student not found for id::" + id);
        }
        return student;
    }

    public Student get(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void deleteStudentById(long id) {
        this.studentRepository.deleteById(id);
    }

    public List<Course> listCourses() {
        return courseRepository.findAll();
    }
}
