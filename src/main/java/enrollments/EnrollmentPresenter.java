package enrollments;

import utils.Presenter;

import java.util.List;

public class EnrollmentPresenter extends Presenter<Enrollment>{

    private final EnrollmentView view;
    private EnrollmentService service = new EnrollmentService();

    public EnrollmentPresenter(final EnrollmentView enrollmentView) {
        this.view= enrollmentView;
    }

    @Override
    public void create(final Enrollment enrollment){
        service.create(enrollment);
        view.update();
    }

    @Override
    public void update(final Enrollment entity) {

    }

    @Override
    public List<Enrollment> findAll() {
        return service.findAll();
    }

    @Override
    public void delete(final Enrollment enrollment) {
        service.delete(enrollment);
        view.update();
    }
}
