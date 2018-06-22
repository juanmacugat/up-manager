package repository;

import domain.Course;
import domain.Grade;
import domain.Student;
import domain.Teacher;
import org.junit.After;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class GradeRepositoryTest {

    @After
    public void tearDown(){
        GradeRepository.getInstance().deleteAll();
    }

    @Test
    public void testSaveGradeForParticularStudentAndCourse(){

        Student student = new Student();
        student.setId(UUID.randomUUID().toString());
        student.setName("NOMBRE");
        student.setSurname("APELLIDO");
        student.setLegajo("STUDENT#1");

        Teacher teacher = new Teacher();
        teacher.setId(UUID.randomUUID().toString());
        teacher.setName("NOMBRE PROFESOR");
        teacher.setSurname("APELLIDO PROFESOR");

        Course course = new Course();
        course.setId(UUID.randomUUID().toString());
        course.setName("LABORATORIO #1");
        course.setTeacher(teacher);

        Grade grade = new Grade();
        grade.setId(UUID.randomUUID().toString());
        grade.setStudent(student);
        grade.setGrade(10);
        grade.setCourse(course);

        Grade gradeSaved = GradeRepository.getInstance().save(grade);

        assertEquals(grade.getId(), gradeSaved.getId());
        assertEquals(grade.getGrade(), gradeSaved.getGrade());
    }

}
