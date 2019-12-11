package courses;

import java.util.List;

public class CoursesPresenter {

    private CoursesView view;
    private CourseService courseService = new CourseServiceImpl();

    public CoursesPresenter(CoursesView view) {

    }

    public List<Course> getAllCourses() {
        return courseService.findAllCourses();
    }
}
