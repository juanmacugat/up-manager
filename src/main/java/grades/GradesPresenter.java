package grades;

import presenter.Presenter;

import java.util.List;

public class GradesPresenter extends Presenter<Grade> {

    private final GradesView view;
    private GradeService service = new GradeService();

    public GradesPresenter(final GradesView view) {
        this.view = view;
    }

    @Override
    public void create(final Grade grade) {
        service.create(grade);
        view.update();
    }

    @Override
    public void update(final Grade entity) {
        service.update(entity);
        view.update();
    }

    @Override
    public List<Grade> findAll() {
        return service.findAll();
    }

    @Override
    public void delete(final Grade entity) {
        service.delete(entity);
        view.update();
    }
}
