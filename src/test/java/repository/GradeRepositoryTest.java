package repository;

import courses.Course;
import grades.Grade;
import grades.GradeRepository;
import students.Student;
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
        student.setEmail("student@up.com");

        Course course = new Course();
        course.setId(UUID.randomUUID().toString());
        course.setName("LABORATORIO #1");

        Grade grade = new Grade();
        grade.setId(UUID.randomUUID().toString());
//        grade.setStudent(student);
        grade.setGrade(10);
//        grade.setCourse(course);

        Grade gradeSaved = GradeRepository.getInstance().save(grade);

        assertEquals(grade.getId(), gradeSaved.getId());
        assertEquals(grade.getGrade(), gradeSaved.getGrade());
    }

    @Test
    public void testGetAllGrades(){

    }

    @Test
    public void testGetGradeById(){

    }

    @Test
    public void testDeleteGrade(){

    }

    @Test
    public void testUpdateGrade(){

    }

}
