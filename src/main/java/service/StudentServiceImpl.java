package service;

import domain.Student;
import repository.StudentRepository;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository = StudentRepository.getInstance();

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        studentRepository.update(student);
        return getById(student.getId());
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(String id) {
        return studentRepository.findById(id);
    }

    @Override
    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }
}
