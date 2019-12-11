package courses;

import java.util.List;

public interface CourseService {

    public List<Course> findAllCourses();

    public void addCourse(Course course);

    public void deleteCourse(Course course);

    public void editCourse(Course course);
}
