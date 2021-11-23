package com.example.bits.controller;

import com.example.bits.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.bits.service.StudentService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    //display list of students
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listStudents", studentService.getAllStudents());
        return "studentManagementPage";
    }
    @GetMapping("/showStudentRegisterForm")
    public String showStudentRegisterForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "studentRegisterForm";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/showStudentUpdateForm/{id}")
    public String showStudentUpdateForm(@PathVariable(value = "id") long id, Model model){
        Student student =studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "studentUpdateForm";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id") long id){
        this.studentService.deleteStudentById(id);
        return "redirect:/";
    }
}
