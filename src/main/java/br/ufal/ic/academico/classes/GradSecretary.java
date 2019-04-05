package br.ufal.ic.academico.classes;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Entity
public class GradSecretary extends Secretary {
    @Setter
    private String name;
    public GradSecretary(String name) {
        this.name = name;

    }
}
