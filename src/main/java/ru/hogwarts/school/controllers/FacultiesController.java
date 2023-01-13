package ru.hogwarts.school.controllers;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.services.FacultyService;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("faculties")
public class FacultiesController {
    private final FacultyService facultyService;

    public FacultiesController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public Faculty getFacultyInfo(@PathVariable Long id) {
        return this.facultyService.getFacultyInfo(id);
    }

    @GetMapping("/filterBy{colour}")
    public Collection<Faculty> sortByColour(@PathVariable String colour) {
        return this.facultyService.getAllFacultiesInfo().stream().filter(e->e.getColour().matches(colour)).collect(Collectors.toList());
    }

    @GetMapping
    public Collection<Faculty> getAllFacultiesInfo() {
        return this.facultyService.getAllFacultiesInfo();
    }

    @PostMapping
    public Faculty createFaculty(Faculty faculty) {
        return this.facultyService.createFaculty(faculty);
    }

    @PutMapping
    public Faculty updateFacultyInfo(@RequestBody Faculty faculty) {
        return this.facultyService.updateFacultyInfo(faculty);
    }

    @DeleteMapping("{id}")
    public Faculty deleteFaculty(@PathVariable Long id) {
        return this.facultyService.deleteFaculty(id);
    }
}
