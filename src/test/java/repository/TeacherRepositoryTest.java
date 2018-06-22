package repository;

import domain.Teacher;
import org.junit.After;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TeacherRepositoryTest {

    @After
    public void tearDown(){
        TeacherRepository.getInstance().deleteAll();
    }

    @Test
    public void saveTeacher(){

        Teacher student = new Teacher();
        student.setId(UUID.randomUUID().toString());
        student.setName("NOMBRE");
        student.setSurname("APELLIDO");

        Teacher studentSaved = TeacherRepository.getInstance().save(student);

        assertEquals(student.getId(), studentSaved.getId());
        assertEquals(student.getName(), studentSaved.getName());
        assertEquals(student.getSurname(), studentSaved.getSurname());
    }

    @Test
    public void findAllTeachers(){

        Teacher student = new Teacher();
        student.setId(UUID.randomUUID().toString());
        student.setName("NOMBRE");
        student.setSurname("APELLIDO");

        TeacherRepository.getInstance().save(student);

        Teacher student2 = new Teacher();
        student2.setId(UUID.randomUUID().toString());
        student2.setName("NOMBRE");
        student2.setSurname("APELLIDO");

        TeacherRepository.getInstance().save(student2);

        List<Teacher> allTeachers = TeacherRepository.getInstance().findAll();
        assertTrue(!allTeachers.isEmpty());
    }

    @Test
    public void updateTeacher(){

        Teacher student = new Teacher();
        student.setId(UUID.randomUUID().toString());
        student.setName("NOMBRE");
        student.setSurname("APELLIDO");

        Teacher studentSaved = TeacherRepository.getInstance().save(student);

        studentSaved.setName("NOMBRE NUEVO");

        TeacherRepository.getInstance().update(studentSaved);

        Teacher studentUpdated = TeacherRepository.getInstance().findById(studentSaved.getId());

        assertEquals(studentUpdated.getId(), studentSaved.getId());
        assertEquals(studentUpdated.getName(), studentSaved.getName());
        assertEquals(studentUpdated.getSurname(), studentSaved.getSurname());

    }

    @Test
    public void findTeacherById(){

        Teacher student = new Teacher();
        student.setId(UUID.randomUUID().toString());
        student.setName("NOMBRE");
        student.setSurname("APELLIDO");

        TeacherRepository.getInstance().save(student);

        Teacher studentSaved = TeacherRepository.getInstance().findById(student.getId());
        assertEquals(student.getId(), studentSaved.getId());
        assertEquals(student.getName(), studentSaved.getName());
        assertEquals(student.getSurname(), studentSaved.getSurname());

    }

    @Test
    public void deleteTeacherById(){
        Teacher student = new Teacher();
        student.setId(UUID.randomUUID().toString());
        student.setName("NOMBRE");
        student.setSurname("APELLIDO");

        TeacherRepository.getInstance().save(student);

        TeacherRepository.getInstance().delete(student);

        assertTrue(TeacherRepository.getInstance().findAll().isEmpty());

    }

}
