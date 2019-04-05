package br.ufal.ic.academico.classes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@MappedSuperclass
public class Secretary {
    @Id
    protected long id;
    @OneToMany() protected List<Course> courses = new ArrayList<Course>();
}
