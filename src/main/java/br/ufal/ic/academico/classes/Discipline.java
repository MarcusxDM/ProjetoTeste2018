package br.ufal.ic.academico.classes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@Table(name = "discipline")
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter private String name;

    @Setter private Integer credits;

    @Setter private Integer requiredCredits;

    @Setter private Boolean optional;

    @ManyToOne()
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany()
    private Set<Discipline> requiredDisciplines = new HashSet<Discipline>();

    public Discipline(String name, Integer credits, Integer requiredCredits) {
        this.name = name;
        this.credits = credits;
        this.requiredCredits = requiredCredits;
    }
}
