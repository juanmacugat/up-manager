package enrollments;

public class EnrollmentPresenter {

    private final EnrollmentView view;
    private EnrollmentService service = new EnrollmentServiceImpl();

    public EnrollmentPresenter(final EnrollmentView enrollmentView) {
        this.view= enrollmentView;
    }

    public void createEnrollment(final Enrollment enrollment){
        service.createEnrollment(enrollment);
        view.update();
    }

    public void deleteEnrollment(final Enrollment enrollment) {
        service.deleteEnrollment(enrollment);
        view.update();
    }
}
