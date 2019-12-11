package courses;

import java.util.List;

public interface CourseService {

    public List<Course> findAllCourses();

    public Course createCourse(final Course course);

    public void deleteCourse(final Course course);

    public Course updateCourse(final Course course);
}
