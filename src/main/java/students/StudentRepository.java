package students;

import repository.RelationalRepository;

public class StudentRepository implements RelationalRepository<Student, String> {

    private static StudentRepository instance = new StudentRepository();

    public static StudentRepository getInstance() {
        return instance;
    }

}
