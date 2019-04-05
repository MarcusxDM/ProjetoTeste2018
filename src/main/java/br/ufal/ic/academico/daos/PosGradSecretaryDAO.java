package br.ufal.ic.academico.daos;

import br.ufal.ic.academico.classes.PosGradSecretary;
import io.dropwizard.hibernate.AbstractDAO;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

@Slf4j
public class PosGradSecretaryDAO extends AbstractDAO<PosGradSecretary> {

    public PosGradSecretaryDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public PosGradSecretary get(Serializable id) throws HibernateException {
        log.info("getting PosGradSecretary: id={}", id);
        return super.get(id);
    }
    
    public List<PosGradSecretary> list() throws HibernateException {
        log.info("getting PosGradSecretary");
        return super.list(query("from PosGradSecretary"));
    }
    
    @Override
    public PosGradSecretary persist(PosGradSecretary entity) throws HibernateException {
        return super.persist(entity);
    }
}
