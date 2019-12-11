package courses;

import students.StudentRepository;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private CourseRepository repository = CourseRepository.getInstance();

    @Override
    public List<Course> findAllCourses() {
        return repository.findAll();
    }

    @Override
    public Course createCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public void deleteCourse(Course course) {
        repository.delete(course);
    }

    @Override
    public Course updateCourse(Course course) {
        repository.update(course);
        return getById(course.getId());
    }

    private Course getById(final String id) {
        return repository.findById(id);
    }
}
