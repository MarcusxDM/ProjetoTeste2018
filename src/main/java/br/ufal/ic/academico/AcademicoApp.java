package br.ufal.ic.academico;

import br.ufal.ic.academico.classes.MyResource;
import br.ufal.ic.academico.classes.Person;
import br.ufal.ic.academico.classes.PersonDAO;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Willy
 */
@Slf4j
public class AcademicoApp extends Application<ConfigApp> {

    public static void main(String[] args) throws Exception {
        new AcademicoApp().run("server", "src/main/resources/config.yml");
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<ConfigApp> bootstrap) {
        log.info("initialize");
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(ConfigApp config, Environment environment) {
        
        final PersonDAO dao = new PersonDAO(hibernate.getSessionFactory());

        final MyResource resource = new MyResource(dao);
        
        environment.jersey().register(resource);
    }

    private final HibernateBundle<ConfigApp> hibernate
            = new HibernateBundle<ConfigApp>(Person.class) {
        
        @Override
        public DataSourceFactory getDataSourceFactory(ConfigApp configuration) {
            return configuration.getDatabase();
        }
    };
}
