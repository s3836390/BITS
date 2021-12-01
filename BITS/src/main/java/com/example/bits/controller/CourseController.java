package com.example.bits.controller;

import com.example.bits.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.bits.service.CourseService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/course")
    public String viewHomePage(Model model){
        model.addAttribute("listCourses", courseService.getAllCourses());
        return "courseManagementPage";
    }

    @GetMapping("/showCourseRegisterForm")
    public String showCourseRegisterForm(Model model){
        Course course = new Course();
        model.addAttribute("course", course);
        return "courseRegisterForm";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course course){
        courseService.saveCourse(course);
        return "redirect:/course";
    }

    @GetMapping("/showCourseUpdateForm/{id}")
    public String showCourseUpdateForm(@PathVariable(value = "id") long id, Model model){
        Course course =courseService.getCourseById(id);
        model.addAttribute("course", course);
        return "courseUpdateForm";
    }

    @GetMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable(value = "id") long id){
        this.courseService.deleteCourseById(id);
        return "redirect:/course";
    }
}
