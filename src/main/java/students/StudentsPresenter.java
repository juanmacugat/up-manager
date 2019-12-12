package students;

public class StudentsPresenter {

    private final NewStudentsView view;
    private final StudentService service = new StudentServiceImpl();

    public StudentsPresenter(final NewStudentsView view){
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
