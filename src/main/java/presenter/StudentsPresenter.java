package presenter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import domain.Student;
import repository.StudentRepository;
import service.StudentService;
import service.StudentServiceImpl;
import view.StudentsView;

import javax.swing.*;
import java.util.List;

@Getter
@Setter
public class StudentsPresenter {

    private StudentsView view;
    private StudentService studentService = new StudentServiceImpl();

    public void createStudent(Student student){
        Student saved = studentService.createStudent(student);
        JOptionPane.showMessageDialog(null,
                "Student saved: " + saved.getId(),
                "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public void updateStudent(Student student){
        Student updated = studentService.updateStudent(student);
        JOptionPane.showMessageDialog(null,
                "Student saved: " + updated.getId(),
                "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public List<Student> findAllStudents(){
        return studentService.getAllStudents();
    }

    public Student findStudentById(String id){
        return studentService.getById(id);
    }

    public void deleteStudent(Student student){
        studentService.deleteStudent(student);
    }

}
