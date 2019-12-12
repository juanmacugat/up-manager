package students;

import presenter.Service;

import java.util.List;

public class StudentService extends Service<Student> {

    private StudentRepository studentRepository = StudentRepository.getInstance();

    @Override
    public Student create(final Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(final Student student) {
        studentRepository.update(student);
        return findById(student.getId());
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(final String id) {
        return studentRepository.findById(id);
    }

    @Override
    public void delete(final Student student) {
        studentRepository.delete(student);
    }
}
