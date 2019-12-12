package students;

import utils.Presenter;

import java.util.List;

public class StudentsPresenter extends Presenter<Student> {

    private final StudentsView view;
    private final StudentService service = new StudentService();

    public StudentsPresenter(final StudentsView view){
        this.view = view;
    }

    @Override
    public void create(final Student student){
        service.create(student);
        view.update();
    }

    @Override
    public void update(final Student student){
        service.update(student);
        view.update();
    }

    @Override
    public List<Student> findAll() {
        return service.findAll();
    }

    @Override
    public void delete(final Student student){
        service.delete(student);
        view.update();
    }

}
