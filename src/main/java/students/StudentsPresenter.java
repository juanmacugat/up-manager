package students;

import java.util.List;

public class StudentsPresenter {

    private final StudentsView view;
    private final StudentService service = new StudentServiceImpl();

    public StudentsPresenter(StudentsView view){
        this.view = view;
    }

    public void createStudent(Student student){
        Student saved = service.createStudent(student);
        view.update(saved);
        view.clear();
    }

    public void updateStudent(Student student){
        service.updateStudent(student);
        view.update(student);
        view.clear();
    }

    public List<Student> findAllStudents(){
        return service.getAllStudents();
    }

    public Student findStudentById(String id){
        return service.getById(id);
    }

    public void deleteStudent(Student student){
        service.deleteStudent(student);
        view.update(student);
        view.clear();
    }

}
