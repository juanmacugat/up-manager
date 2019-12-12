package grades;

public class GradesPresenter {

    private final GradesView view;
    private GradeService service = new GradeServiceImpl();

    public GradesPresenter(final GradesView view) {
        this.view = view;
    }

    public void createGrade(final Grade grade) {
        service.createGrade(grade);
        view.update();
    }
}
