package enrollments;

import courses.Course;
import courses.CourseRepository;
import repository.RelationalRepository;
import students.Student;

import java.util.List;
import java.util.stream.Collectors;

public class EnrollmentRepository implements RelationalRepository<Enrollment, String> {

    private static EnrollmentRepository instance = new EnrollmentRepository();

    public static EnrollmentRepository getInstance() {
        return instance;
    }

    public List<Course> findCoursesByStudent(final Student student) {
        return findAll().stream()
                .filter(enrollment -> enrollment.getStudent_id().equals(student.getId()))
                .map(enrollment -> enrollment.getCourse_id())
                .map(id -> CourseRepository.getInstance().findById(id))
                .collect(Collectors.toList());
    }
}
