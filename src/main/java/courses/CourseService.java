package courses;

import utils.Service;

import java.util.List;

public class CourseService extends Service<Course> {

    private CourseRepository repository = CourseRepository.getInstance();

    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }

    @Override
    public Course create(final Course course) {
        return repository.save(course);
    }

    @Override
    public void delete(final Course course) {
        repository.delete(course);
    }

    @Override
    public Course update(final Course course) {
        repository.update(course);
        return findById(course.getId());
    }

    @Override
    public Course findById(final String id) {
        return repository.findById(id);
    }
}
