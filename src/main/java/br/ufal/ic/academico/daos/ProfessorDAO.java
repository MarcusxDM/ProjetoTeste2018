package br.ufal.ic.academico.daos;

import br.ufal.ic.academico.classes.Professor;
import io.dropwizard.hibernate.AbstractDAO;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Willy
 */
@Slf4j
public class ProfessorDAO extends AbstractDAO<Professor> {

    public ProfessorDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Professor get(Serializable id) throws HibernateException {
        log.info("getting professor: id={}", id);
        return super.get(id);
    }
    
    public List<Professor> list() throws HibernateException {
        log.info("getting professor");
        return super.list(query("from Professor"));
    }
    
    @Override
    public Professor persist(Professor entity) throws HibernateException {
        return super.persist(entity);
    }
}
