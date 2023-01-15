package ru.hogwarts.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private Integer age;

    public Student() {
    }
}
