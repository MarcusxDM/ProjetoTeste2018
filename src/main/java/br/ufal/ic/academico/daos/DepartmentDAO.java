package br.ufal.ic.academico.daos;

import br.ufal.ic.academico.classes.Department;
import br.ufal.ic.academico.classes.Person;
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
public class DepartmentDAO extends AbstractDAO<Department> {

    public DepartmentDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Department get(Serializable id) throws HibernateException {
        log.info("getting person: id={}", id);
        return super.get(id);
    }
    
    public List<Department> list() throws HibernateException {
        log.info("getting departments");
        return super.list(query("from Department"));
    }
    
    @Override
    public Department persist(Department entity) throws HibernateException {
        return super.persist(entity);
    }
}
