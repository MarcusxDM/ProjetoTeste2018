package br.ufal.ic.academico.daos;

import br.ufal.ic.academico.classes.Course;
import io.dropwizard.hibernate.AbstractDAO;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;


@Slf4j
public class CourseDAO extends AbstractDAO<Course> {

    public CourseDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Course get(Serializable id) throws HibernateException {
        log.info("getting Course: id={}", id);
        return super.get(id);
    }
    
    public List<Course> list() throws HibernateException {
        log.info("getting Course");
        return super.list(query("from Course"));
    }
    
    @Override
    public Course persist(Course entity) throws HibernateException {
        return super.persist(entity);
    }
}
