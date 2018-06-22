package repository;

import model.Course;
import model.Teacher;
import org.junit.After;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CourseRepositoryTest {

    @After
    public void tearDown(){
        CourseRepository.getInstance().deleteAll();
    }

    @Test
    public void testSaveCourse(){

        Teacher teacher = new Teacher();
        teacher.setId(UUID.randomUUID().toString());
        teacher.setName("NOMBRE PROFESOR");
        teacher.setSurname("APELLIDO PROFESOR");

        Course course = new Course();
        course.setId(UUID.randomUUID().toString());
        course.setName("LABORATORIO #1");
        course.setTeacher(teacher);

        Course courseSaved = CourseRepository.getInstance().save(course);

        assertNotNull(courseSaved);
    }

    @Test
    public void testGetCourseById(){

        Teacher teacher = new Teacher();
        teacher.setId(UUID.randomUUID().toString());
        teacher.setName("NOMBRE PROFESOR");
        teacher.setSurname("APELLIDO PROFESOR");

        Course course = new Course();
        course.setId(UUID.randomUUID().toString());
        course.setName("LABORATORIO #1");
        course.setTeacher(teacher);

        CourseRepository.getInstance().save(course);

        Course courseSaved = CourseRepository.getInstance().findById(course.getId());

        assertEquals(course.getId(), courseSaved.getId());
        assertEquals(course.getName(), courseSaved.getName());
        assertEquals(null, courseSaved.getTeacher());
    }
}
