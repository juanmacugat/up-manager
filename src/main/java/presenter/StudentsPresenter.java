package presenter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import domain.Student;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingListener;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import repository.StudentRepository;
import service.StudentService;
import service.StudentServiceImpl;
import view.StudentsView;

import javax.swing.*;
import java.util.Date;
import java.util.List;

import static org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ;
import static org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE;

@Getter
@Setter
public class StudentsPresenter {

    private JTableBinding tb;
    private StudentsView view;
    private StudentService studentService = new StudentServiceImpl();
    private Student selectedStudent;

    public StudentsPresenter(StudentsView view){
        tb = SwingBindings.createJTableBinding(READ_WRITE, findAllStudents(), view.getStudentsTable());
        BeanProperty id = BeanProperty.create("id");
        BeanProperty name = BeanProperty.create("name");
        BeanProperty surname = BeanProperty.create("surname");
        BeanProperty email = BeanProperty.create("email");
        BeanProperty birthday = BeanProperty.create("birthday");
        BeanProperty creationDate = BeanProperty.create("creation_date");

        BeanProperty selectedElement = BeanProperty.create("selectedElement");

        tb.addColumnBinding(id)
                .setEditable(false)
                .setColumnName("Id")
                .setColumnClass(String.class);
        tb.addColumnBinding(name)
                .setColumnName("Name")
                .setColumnClass(String.class);
        tb.addColumnBinding(surname)
                .setColumnName("Surname")
                .setColumnClass(String.class);
        tb.addColumnBinding(email)
                .setColumnName("Email")
                .setColumnClass(String.class);
        tb.addColumnBinding(birthday)
                .setColumnName("Birthday")
                .setColumnClass(Date.class);
        tb.addColumnBinding(creationDate)
                .setColumnName("Creation date")
                .setColumnClass(Date.class);
        tb.bind();

    }

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
