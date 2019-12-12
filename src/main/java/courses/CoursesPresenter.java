package courses;

import java.util.List;

public class CoursesPresenter {

    private CoursesView view;
    private CourseService service = new CourseServiceImpl();

    public CoursesPresenter(CoursesView view) {
        this.view = view;
    }

    public void createCourse(final Course course){
        service.createCourse(course);
        view.update();
    }

    public void updateCourse(final Course course){
        service.updateCourse(course);
        view.update();
    }

    public List<Course> findAllCourses() {
        return service.findAllCourses();
    }

    public void deleteCourse(final Course course) {
        service.deleteCourse(course);
        view.update();
    }
}
