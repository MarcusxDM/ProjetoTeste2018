package br.ufal.ic.academico.daos;

import br.ufal.ic.academico.classes.Discipline;
import io.dropwizard.hibernate.AbstractDAO;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;


@Slf4j
public class DisciplineDAO extends AbstractDAO<Discipline> {

    public DisciplineDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Discipline get(Serializable id) throws HibernateException {
        log.info("getting Discipline: id={}", id);
        return super.get(id);
    }
    
    public List<Discipline> list() throws HibernateException {
        log.info("getting Discipline");
        return super.list(query("from Discipline"));
    }
    
    @Override
    public Discipline persist(Discipline entity) throws HibernateException {
        return super.persist(entity);
    }
}
