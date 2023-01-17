package ru.hogwarts.school.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity getFacultyInfo(@PathVariable Long id) {
        Faculty faculty = facultyService.getFacultyInfo(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }return ResponseEntity.ok(faculty);
    }

    @GetMapping("/filterBy{colour}")
    public ResponseEntity sortByColour(@PathVariable String colour) {
        Collection<Faculty>sortedByColour = this.facultyService.getAllFaculties().stream()
                .filter(e->e.getColour().matches(colour)).collect(Collectors.toList());
        if (sortedByColour == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sortedByColour);
    }

    @GetMapping
    public Collection<Faculty> getAllFacultiesInfo(@RequestParam(required = false) String name) {
        if (name != null && !name.isEmpty()) {
            return this.facultyService.findByNameContainsIgnoreCase(name);
        }
        return this.facultyService.getAllFaculties();
    }

    @PostMapping
    public Faculty createFaculty(Faculty faculty) {
        return this.facultyService.createFaculty(faculty);
    }

    @PutMapping
    public ResponseEntity updateFacultyInfo(@RequestBody Faculty faculty) {
        Faculty foundFaculty = facultyService.updateFacultyInfo(faculty);
        if (foundFaculty == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(faculty);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteFaculty(@PathVariable Long id) {
        this.facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }
}
