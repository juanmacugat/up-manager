package presenter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.Student;
import repository.StudentRepository;
import view.StudentView;

import javax.swing.*;

@Getter
@Setter
@AllArgsConstructor
public class StudentPresenter {

    private StudentView studentView;

    public void initialize(){
        studentView.getSaveButton().addActionListener(e -> saveStudent());
    }

    private void saveStudent() {
        Student saved = StudentRepository.getInstance().save(null);
        JOptionPane.showMessageDialog(null,
                "Student saved: " + saved.getId(),
                "Information", JOptionPane.INFORMATION_MESSAGE);
    }

//    private StudentRepository studentRepository = StudentRepository.getInstance();
//
//    public void createStudent(Student student){
//        studentRepository.save(student);
//    }
//
//    public void updateStudent(Student student){
//        studentRepository.update(student);
//    }
//
//    public List<Student> findAllStudents(){
//        return studentRepository.findAll();
//    }
//
//    public Student findStudentById(String id){
//        return studentRepository.findById(id);
//    }
//
//    public void deleteStudent(Student student){
//        studentRepository.delete(student);
//    }

}