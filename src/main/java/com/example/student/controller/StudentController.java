package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @GetMapping("")
    public String index(Model model) {
        List<Student> studentList = iStudentService.findAll();
        model.addAttribute("students", studentList);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute("student") Student student) {
        iStudentService.save(student);
        return "redirect:/student";
    }

    @GetMapping("/{id}")
    public String viewStudent(@PathVariable Long id, Model model) {
        Student student = iStudentService.findById(id);
        model.addAttribute("student", student);
        return "view";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Student student = iStudentService.findById(id);
        model.addAttribute("student", student);
        return "edit";
    }

    @PostMapping("/edit")
    public String updateStudent(@ModelAttribute("student") Student student) {
        iStudentService.save(student);
        return "redirect:/student";
    }
}
