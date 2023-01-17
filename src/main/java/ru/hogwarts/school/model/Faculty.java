package ru.hogwarts.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String colour;
    @OneToMany(mappedBy = "faculty")
    private Collection<Student>students;

    public Faculty() {
    }
}
