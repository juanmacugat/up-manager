package enrollments;

import java.util.List;

public interface EnrollmentService {

    Enrollment createEnrollment(final Enrollment enrollment);

    Enrollment updateEnrollment(final Enrollment enrollment);

    List<Enrollment> getAllEnrollments();

    Enrollment getById(Integer id);

    void deleteEnrollment(Enrollment enrollment);
}
