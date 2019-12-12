package enrollments;

import repository.RelationalRepository;

public class EnrollmentRepository implements RelationalRepository<Enrollment, Integer> {

    private static EnrollmentRepository instance = new EnrollmentRepository();

    public static EnrollmentRepository getInstance() {
        return instance;
    }
}
