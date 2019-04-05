package br.ufal.ic.academico.classes;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;


@Getter
@Entity
public class PosGradSecretary extends Secretary {
    private String name;
    public PosGradSecretary(String name) {
        this.name = name;
    }
}
