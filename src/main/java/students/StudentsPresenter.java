package students;

public class StudentsPresenter {

    private final StudentsView view;
    private final StudentService service = new StudentServiceImpl();

    public StudentsPresenter(final StudentsView view){
        this.view = view;
    }

    public void createStudent(Student student){
        service.createStudent(student);
        view.update();
    }

    public void updateStudent(Student student){
        service.updateStudent(student);
        view.update();
    }

    public void deleteStudent(Student student){
        service.deleteStudent(student);
        view.update();
    }

}
