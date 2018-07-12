package repository;

import domain.Student;
import org.junit.After;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StudentRepositoryTest {

    @After
    public void tearDown(){
        StudentRepository.getInstance().deleteAll();
    }

    @Test
    public void saveStudent(){

        Student student = new Student();
        student.setId(UUID.randomUUID().toString());
        student.setName("NOMBRE");
        student.setSurname("APELLIDO");
        student.setEmail("student@up.com");
        student.setBirthday(new Date());
        student.setCreation_date(new Date());

        Student studentSaved = StudentRepository.getInstance().save(student);

        assertEquals(student.getId(), studentSaved.getId());
        assertEquals(student.getName(), studentSaved.getName());
        assertEquals(student.getSurname(), studentSaved.getSurname());
        assertEquals(student.getEmail(), studentSaved.getEmail());
    }

    @Test
    public void findAllStudents(){

        Student student = new Student();
        student.setId(UUID.randomUUID().toString());
        student.setName("NOMBRE");
        student.setSurname("APELLIDO");
        student.setEmail("student@up.com");
        student.setBirthday(new Date());
        student.setCreation_date(new Date());

        StudentRepository.getInstance().save(student);

        Student student2 = new Student();
        student2.setId(UUID.randomUUID().toString());
        student2.setName("NOMBRE");
        student2.setSurname("APELLIDO");
        student2.setEmail("student@up.com");
        student2.setBirthday(new Date());
        student2.setCreation_date(new Date());

        StudentRepository.getInstance().save(student2);

        List<Student> allStudents = StudentRepository.getInstance().findAll();
        assertTrue(!allStudents.isEmpty());
    }

    @Test
    public void updateStudent(){

        Student student = new Student();
        student.setId(UUID.randomUUID().toString());
        student.setName("NOMBRE");
        student.setSurname("APELLIDO");
        student.setEmail("student@up.com");
        student.setBirthday(new Date());
        student.setCreation_date(new Date());

        Student studentSaved = StudentRepository.getInstance().save(student);

        studentSaved.setName("NOMBRE NUEVO");

        StudentRepository.getInstance().update(studentSaved);

        Student studentUpdated = StudentRepository.getInstance().findById(studentSaved.getId());

        assertEquals(studentUpdated.getId(), studentSaved.getId());
        assertEquals(studentUpdated.getName(), studentSaved.getName());
        assertEquals(studentUpdated.getSurname(), studentSaved.getSurname());
        assertEquals(studentUpdated.getEmail(), studentSaved.getEmail());

    }

    @Test
    public void findStudentById(){

        Student student = new Student();
        student.setId(UUID.randomUUID().toString());
        student.setName("NOMBRE");
        student.setSurname("APELLIDO");
        student.setEmail("student@up.com");
        student.setBirthday(new Date());
        student.setCreation_date(new Date());

        StudentRepository.getInstance().save(student);

        Student studentSaved = StudentRepository.getInstance().findById(student.getId());
        assertEquals(student.getId(), studentSaved.getId());
        assertEquals(student.getName(), studentSaved.getName());
        assertEquals(student.getSurname(), studentSaved.getSurname());
        assertEquals(student.getEmail(), studentSaved.getEmail());

    }

    @Test
    public void deleteStudentById(){
        Student student = new Student();
        student.setId(UUID.randomUUID().toString());
        student.setName("NOMBRE");
        student.setSurname("APELLIDO");
        student.setEmail("student@up.com");
        student.setBirthday(new Date());
        student.setCreation_date(new Date());

        StudentRepository.getInstance().save(student);

        StudentRepository.getInstance().delete(student);

        assertTrue(StudentRepository.getInstance().findAll().isEmpty());

    }
}
