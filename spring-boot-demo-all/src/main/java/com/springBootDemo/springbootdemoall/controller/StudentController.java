package com.springBootDemo.springbootdemoall.controller;

import com.springBootDemo.springbootdemoall.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/login-page")
    public String showLoginPage(Model model){
        Student s = Student.builder().firstName("Arkadyuti").build();

        model.addAttribute("student", s);
        model.addAttribute("remarkList", new ArrayList<>(List.of("Excellent", "Very Good", "Good", "Mediocre", "Bad")));
        return "login-page-student";
    }

    @PostMapping("/personal-library")
    public String showPersonalLibrary(@ModelAttribute("student") Student stu, Model model){
        System.out.println(stu);
        return showLoginPage(model);
    }

}
