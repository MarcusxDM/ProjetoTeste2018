package br.ufal.ic.academico.daos;

import br.ufal.ic.academico.classes.Student;
import io.dropwizard.hibernate.AbstractDAO;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;


@Slf4j
public class StudentDAO extends AbstractDAO<Student> {

    public StudentDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Student get(Serializable id) throws HibernateException {
        log.info("getting Student: id={}", id);
        return super.get(id);
    }
    
    public List<Student> list() throws HibernateException {
        log.info("getting Student");
        return super.list(query("from Student"));
    }
    
    @Override
    public Student persist(Student entity) throws HibernateException {
        return super.persist(entity);
    }
}
