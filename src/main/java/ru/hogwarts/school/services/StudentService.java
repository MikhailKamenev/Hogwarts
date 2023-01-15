package ru.hogwarts.school.services;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
       return this.studentRepository.save(student);
    }

    public Student getStudent(long id) {
        return this.studentRepository.findById(id).get();
    }

    public Collection<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    public Student updateInfo(Student student) {
        return this.studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        this.studentRepository.deleteById(id);
    }
}
