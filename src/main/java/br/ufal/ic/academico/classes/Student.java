package br.ufal.ic.academico.classes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
public class Student {
    @OneToMany
    private List<Discipline> disciplines;

    @OneToOne
    private Course course;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Setter
    private int credits;

    public Student(String name) {
        this.name = name;
    }
}
