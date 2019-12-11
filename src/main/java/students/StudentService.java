package students;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);

    Student updateStudent(Student student);

    List<Student> getAllStudents();

    Student getById(String id);

    void deleteStudent(Student student);
}
