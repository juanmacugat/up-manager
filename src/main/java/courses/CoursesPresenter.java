package courses;

import java.util.List;

public class CoursesPresenter {

    private CoursesView view;
    private CourseService service = new CourseServiceImpl();

    public CoursesPresenter(CoursesView view) {
        this.view = view;
    }

    public void createCourse(final Course course){
        Course saved = service.createCourse(course);
        view.update(saved);
        view.clear();
    }

    public void updateCourse(final Course course){

    }

    public List<Course> findAllCourses() {
        return service.findAllCourses();
    }
}
