package courses;

import utils.Presenter;

import java.util.List;

public class CoursesPresenter extends Presenter<Course> {

    private CoursesView view;
    private CourseService service = new CourseService();

    public CoursesPresenter(CoursesView view) {
        this.view = view;
    }

    @Override
    public void create(final Course course){
        service.create(course);
        view.update();
    }

    @Override
    public void update(final Course course){
        service.update(course);
        view.update();
    }

    @Override
    public List<Course> findAll() {
        return service.findAll();
    }

    @Override
    public void delete(final Course course) {
        service.delete(course);
        view.update();
    }
}
