package ru.hogwarts.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class Faculty {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String colour;

    public Faculty() {
    }
}
