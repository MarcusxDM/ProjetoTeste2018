package br.ufal.ic.academico.classes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter private String name;

    @OneToMany(mappedBy = "course")
    Set<Discipline> disciplines;

    public Course(String name) {
        this.name = name;
    }
}
