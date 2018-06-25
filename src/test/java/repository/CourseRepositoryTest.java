package repository;

import domain.Course;
import domain.Teacher;
import org.junit.After;
import org.junit.Test;

import java.util.List;
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

    @Test
    public void testGetAllCourses(){

        Teacher teacher1 = new Teacher();
        teacher1.setId(UUID.randomUUID().toString());
        teacher1.setName("NOMBRE PROFESOR");
        teacher1.setSurname("APELLIDO PROFESOR");

        Course course1 = new Course();
        course1.setId(UUID.randomUUID().toString());
        course1.setName("LABORATORIO #1");
        course1.setTeacher(teacher1);

        CourseRepository.getInstance().save(course1);

        Teacher teacher2 = new Teacher();
        teacher2.setId(UUID.randomUUID().toString());
        teacher2.setName("NOMBRE PROFESOR");
        teacher2.setSurname("APELLIDO PROFESOR");

        Course course2 = new Course();
        course2.setId(UUID.randomUUID().toString());
        course2.setName("LABORATORIO #1");
        course2.setTeacher(teacher2);

        CourseRepository.getInstance().save(course2);


        List<Course> allCourses = CourseRepository.getInstance().findAll();

        assertEquals(2, allCourses.size());

    }

    @Test
    public void testDeleteCourseById(){

    }
}
