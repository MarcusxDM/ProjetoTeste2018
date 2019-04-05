package br.ufal.ic.academico.daos;

import br.ufal.ic.academico.classes.GradSecretary;
import br.ufal.ic.academico.classes.Secretary;
import io.dropwizard.hibernate.AbstractDAO;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

@Slf4j
public class GradSecretaryDAO extends AbstractDAO<GradSecretary> {

    public GradSecretaryDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public GradSecretary get(Serializable id) throws HibernateException {
        log.info("getting GradSecretary: id={}", id);
        return super.get(id);
    }
    
    public List<GradSecretary> list() throws HibernateException {
        log.info("getting GradSecretary");
        return super.list(query("from GradSecretary"));
    }
    
    @Override
    public GradSecretary persist(GradSecretary entity) throws HibernateException {
        return super.persist(entity);
    }
}
