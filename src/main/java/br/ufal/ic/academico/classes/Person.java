package br.ufal.ic.academico.classes;

import javax.persistence.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 *
 * @author Willy
 */
@Entity
@Getter
@RequiredArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    @Setter
    private int score;

    public Person(String name) {
        this.name = name;
    }
}
