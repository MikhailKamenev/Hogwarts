package ru.hogwarts.school.services;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {
    private Map<Long, Student>students = new HashMap<>();
    private long id = 0;

    public Student addStudent(Student student) {
        student.setId(++id);
        return this.students.put(id,student);
    }

    public Student getStudent(long id) {
        return this.students.get(id);
    }

    public Collection<Student> getAllStudents() {
        return this.students.values();
    }

    public Student updateInfo(Student student) {
        return this.students.put(student.getId(), student);
    }

    public Student deleteStudent(long id) {
        return this.students.remove(id);
    }
}
