package enrollments;

import java.util.List;

public class EnrollmentServiceImpl implements EnrollmentService {

    private EnrollmentRepository repository = EnrollmentRepository.getInstance();

    @Override
    public Enrollment createEnrollment(final Enrollment enrollment) {
        return repository.save(enrollment);
    }

    @Override
    public Enrollment updateEnrollment(final Enrollment enrollment) {
        repository.update(enrollment);
        return enrollment;
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return repository.findAll();
    }

    @Override
    public Enrollment getById(final Integer id) {
        return repository.findById(id);
    }

    @Override
    public void deleteEnrollment(final Enrollment enrollment) {
        repository.delete(enrollment);
    }
}
