package ru.hogwarts.school.services;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repositories.FacultyRepository;

import java.util.Collection;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        return this.facultyRepository.save(faculty);
    }

    public Faculty getFacultyInfo(long id) {
        return this.facultyRepository.findById(id).get();
    }

    public Collection<Faculty> getAllFaculties() {
        return this.facultyRepository.findAll();
    }
    public Collection<Faculty> findByNameContainsIgnoreCase(String name) {
        return this.facultyRepository.findByNameContainsIgnoreCase(name);
    }

    public Faculty updateFacultyInfo(Faculty faculty) {
        return this.facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        this.facultyRepository.deleteById(id);
    }
}
