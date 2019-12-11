package students;

import javax.swing.*;
import java.util.List;

public class StudentsPresenter {

    private final StudentsView view;
    private final StudentService service = new StudentServiceImpl();

    public StudentsPresenter(StudentsView view){
        this.view = view;
    }

    public void createStudent(Student student){
        Student saved = service.createStudent(student);
        JOptionPane.showMessageDialog(null,
                "Student saved: " + saved.getId(),
                "Information", JOptionPane.INFORMATION_MESSAGE);
        view.clear();
    }

    public void updateStudent(Student student){
        Student updated = service.updateStudent(student);
        JOptionPane.showMessageDialog(null,
                "Student saved: " + updated.getId(),
                "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public List<Student> findAllStudents(){
        return service.getAllStudents();
    }

    public Student findStudentById(String id){
        return service.getById(id);
    }

    public void deleteStudent(Student student){
        service.deleteStudent(student);
    }

}
