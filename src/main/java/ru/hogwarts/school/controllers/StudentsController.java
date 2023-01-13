package ru.hogwarts.school.controllers;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.services.StudentService;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("students")
public class StudentsController {
    private final StudentService studentService;

    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public Student getStudentInfo(@PathVariable Long id) {
        return this.studentService.getStudent(id);
    }

    @GetMapping
    public Collection<Student> getALLStudents() {
        return this.studentService.getAllStudents();
    }

    @GetMapping("/filterBy{age}")
    public Collection<Student> sortByAge(@PathVariable int age) {
        return this.studentService.getAllStudents().stream().filter(e->e.getAge()==age).collect(Collectors.toSet());
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return this.studentService.addStudent(student);
    }

    @PutMapping
    public Student updateStudentInfo(@RequestBody Student student) {
        return this.studentService.updateInfo(student);
    }

    @DeleteMapping("{id}")
    public Student deleteStudent(@PathVariable Long id) {
        return this.studentService.deleteStudent(id);
    }
}
