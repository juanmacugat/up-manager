package presenter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import domain.Student;
import repository.StudentRepository;
import view.StudentsView;

import javax.swing.*;

@Getter
@Setter
@AllArgsConstructor
public class StudentPresenter {

    private StudentsView studentsView;

    public void initialize(){
        studentsView.getSaveButton().addActionListener(e -> saveStudent());
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
