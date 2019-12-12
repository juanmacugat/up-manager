package enrollments;

import presenter.Service;

import java.util.List;

public class EnrollmentService extends Service<Enrollment>{

    private EnrollmentRepository repository = EnrollmentRepository.getInstance();

    @Override
    public Enrollment create(final Enrollment enrollment) {
        return repository.save(enrollment);
    }

    @Override
    public Enrollment update(final Enrollment entity) {
        repository.update(entity);
        return entity;
    }

    @Override
    public List<Enrollment> findAll() {
        return repository.findAll();
    }

    @Override
    public Enrollment findById(final String id) {
        return repository.findById(id);
    }

    @Override
    public void delete(final Enrollment enrollment) {
        repository.delete(enrollment);
    }
}
