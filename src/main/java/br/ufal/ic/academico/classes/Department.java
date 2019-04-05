package br.ufal.ic.academico.classes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import javax.persistence.*;


/**
 *
 * @author Marcus Pestana
 */
@Entity
@Getter
@RequiredArgsConstructor
public class Department {
    @OneToMany
    private List<Professor> professors;

    @OneToOne
    private GradSecretary secretaryGrad;

    @OneToOne
    private PosGradSecretary secretaryPosGrad;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Department(String name) {
        this.name = name;
    }
}
