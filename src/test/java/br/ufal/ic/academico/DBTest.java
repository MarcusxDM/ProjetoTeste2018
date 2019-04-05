package br.ufal.ic.academico;

import br.ufal.ic.academico.classes.*;
import br.ufal.ic.academico.daos.*;
import io.dropwizard.testing.junit5.DAOTestExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import lombok.SneakyThrows;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 *
 * @author Willy
 */
@ExtendWith(DropwizardExtensionsSupport.class)
public class DBTest {


    public DAOTestExtension dbTestingDiscipline = DAOTestExtension.newBuilder()
            .addEntityClass(Discipline.class).build();
    public DAOTestExtension dbTestingCourse = DAOTestExtension.newBuilder()
            .addEntityClass(Course.class).build();
    public DAOTestExtension dbTestingGradSecretary = DAOTestExtension.newBuilder()
            .addEntityClass(GradSecretary.class).build();
    public DAOTestExtension dbTestingPosGradSecretary = DAOTestExtension.newBuilder()
            .addEntityClass(PosGradSecretary.class).build();
    public DAOTestExtension dbTestingDepartmant = DAOTestExtension.newBuilder()
            .addEntityClass(Department.class).build();
    public DAOTestExtension dbTestingStudent = DAOTestExtension.newBuilder()
            .addEntityClass(Student.class).build();
    public DAOTestExtension dbTestingProfessor = DAOTestExtension.newBuilder()
            .addEntityClass(Professor.class).build();
    public DAOTestExtension dbTesting = DAOTestExtension.newBuilder()
            .addEntityClass(Person.class).build();

    private PersonDAO dao;
    private CourseDAO courseDAO;
    private DepartmentDAO departmentDAO;
    private DisciplineDAO disciplineDAO;
    private GradSecretaryDAO gradSecretaryDAO;
    private PosGradSecretaryDAO posGradSecretaryDAO;
    private ProfessorDAO professorDAO;
    private StudentDAO studentDAO;


    @BeforeEach
    @SneakyThrows
    public void setUp() {
        System.out.println("setUp");
        dao = new PersonDAO(dbTesting.getSessionFactory());

        disciplineDAO = new DisciplineDAO(dbTestingDiscipline.getSessionFactory());
        courseDAO = new CourseDAO(dbTestingCourse.getSessionFactory());
        departmentDAO = new DepartmentDAO(dbTestingDepartmant.getSessionFactory());
        gradSecretaryDAO = new GradSecretaryDAO(dbTestingGradSecretary.getSessionFactory());
        posGradSecretaryDAO = new PosGradSecretaryDAO(dbTestingPosGradSecretary.getSessionFactory());
        professorDAO = new ProfessorDAO(dbTestingProfessor.getSessionFactory());
        studentDAO = new StudentDAO(dbTestingStudent.getSessionFactory());
    }
    
    @Test
    public void testCRUD() {

        System.out.println("testCRUD");
        
        Person c1 = new Person("c1");
        
        Person saved = dbTesting.inTransaction(() -> dao.persist(c1));
        
        assertNotNull(saved);
        assertNotNull(saved.getId());
        assertEquals(c1.getName(), saved.getName());
    }

    @Test
    public void testCRUDall() {

        System.out.println("testCRUDall");

        Student student             = new Student("Aluno1");
        Department dept             = new Department("Departamento de Ciencias Aplicadas");
        Discipline disc             = new Discipline("Matemática Basica", 35,0);
        GradSecretary gradSec       = new GradSecretary("Matemática Aplicada");
        PosGradSecretary posGrad    = new PosGradSecretary("Matematicas Especificas");
        Professor prof              = new Professor("Carlos Augusto");
        Course course               = new Course("Bacharelado em Matematica");

        Discipline discSaved             = dbTesting.inTransaction(() -> disciplineDAO.persist(disc));
        Student studentSaved             = dbTesting.inTransaction(() -> studentDAO.persist(student));
        Department deptSaved             = dbTesting.inTransaction(() -> departmentDAO.persist(dept));
        GradSecretary gradSecSaved       = dbTesting.inTransaction(() -> gradSecretaryDAO.persist(gradSec));
        PosGradSecretary posGradSaved    = dbTesting.inTransaction(() -> posGradSecretaryDAO.persist(posGrad));
        Professor profSaved              = dbTesting.inTransaction(() -> professorDAO.persist(prof));
        Course courseSaved               = dbTesting.inTransaction(() -> courseDAO.persist(course));

        assertNotNull(studentSaved);
        assertNotNull(deptSaved);
        assertNotNull(discSaved);
        assertNotNull(gradSecSaved);
        assertNotNull(posGradSaved);
        assertNotNull(profSaved);
        assertNotNull(courseSaved);

        assertNotNull(studentSaved.getId());
        assertNotNull(deptSaved.getId());
        assertNotNull(discSaved.getId());
        assertNotNull(gradSecSaved.getId());
        assertNotNull(posGradSaved.getId());
        assertNotNull(profSaved.getId());
        assertNotNull(courseSaved.getId());

        assertEquals(student.getName(), studentSaved.getName());
        assertEquals(dept.getName(), deptSaved.getName());
        assertEquals(disc.getName(), discSaved.getName());
        assertEquals(gradSec.getName(), gradSecSaved.getName());
        assertEquals(posGrad.getName(), posGradSaved.getName());
        assertEquals(prof.getName(), profSaved.getName());
        assertEquals(course.getName(), courseSaved.getName());
    }
}
