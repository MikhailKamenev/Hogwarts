package ru.hogwarts.school.services;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyService {
    Map<Long,Faculty>faculties = new HashMap<>();
    private long id = 0;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++id);
        return this.faculties.put(id, faculty);
    }

    public Faculty getFacultyInfo(long id) {
        return this.faculties.get(id);
    }

    public Collection<Faculty> getAllFacultiesInfo() {
        return this.faculties.values();
    }

    public Faculty updateFacultyInfo(Faculty faculty) {
        return this.faculties.put(faculty.getId(), faculty);
    }

    public Faculty deleteFaculty(long id) {
        return this.faculties.remove(id);
    }
}
