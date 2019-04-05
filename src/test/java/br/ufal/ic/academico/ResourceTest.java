package br.ufal.ic.academico;

import br.ufal.ic.academico.classes.MyResource;
import br.ufal.ic.academico.classes.Person;
import br.ufal.ic.academico.classes.PersonDAO;
import ch.qos.logback.classic.Level;
import io.dropwizard.logging.BootstrapLogging;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;
import java.lang.reflect.Constructor;
import javax.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Willy
 */
@ExtendWith(DropwizardExtensionsSupport.class)
public class ResourceTest {
    
    static {
        BootstrapLogging.bootstrap(Level.DEBUG);
    }

    private PersonDAO dao = mock(PersonDAO.class);

    private final MyResource resource = new MyResource(dao);

    public ResourceExtension RULE = ResourceExtension.builder()
            .addProvider(new MockBinder())
            .addResource(resource)
            .build();

    /**
     * Caso seu resource utilize o @Context para injetar o HttpServletRequest,
     * daí você precisará utilizar um BinderMock (ver abaixo) e adicioná-lo como
     * um provider no ResourceExtension acima.
     */
    private final HttpServletRequest request = mock(HttpServletRequest.class);
    
    public class MockBinder extends AbstractBinder {

        @Override
        @SneakyThrows
        protected void configure() {
            
            Class clazz = Person.class;
            
            Constructor c = clazz.getConstructor(String.class);
            
            Person requestPerson = (Person) c.newInstance("meu nome");
            
//            Person requestPerson = new Person("meu nome");
            
            when(request.getAttribute(any())).thenReturn(requestPerson);

            bind(request).to(HttpServletRequest.class);
        }
    }
    
    private Person expected;
    
    @BeforeEach
    @SneakyThrows
    public void setUp() {
        System.out.println("setUp");
        
        expected = new Person("outra pessoa");
        FieldUtils.writeField(expected, "id", 12L, true);
        
        when(dao.get(expected.getId())).thenReturn(expected);
    }
    
    @Test
    public void testException() {
        when(dao.get(-1L)).thenThrow(IllegalArgumentException.class);
        
        assertThrows(IllegalArgumentException.class, () -> dao.get(-1L));
    }
    
    @Test
    public void testResource() {

        System.out.println("testResource");
        
        Person saved = RULE.target("/classes/" + expected.getId()).request().get(Person.class);
        
        
        assertNotNull(saved);
        assertEquals(expected.getName(), saved.getName());
        assertEquals(expected.getId(), saved.getId());
        
        Person p = new Person("nova person");
        
//        assertThrows(WebApplicationException.class, () -> {
//            
//            RULE.target("/classes/" + (expected.getId()+1)).request().post(Entity.json(p), Person.class);
//        }, "null");
    }
}
