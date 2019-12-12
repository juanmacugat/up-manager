package grades;

import java.util.List;

public class GradeServiceImpl implements GradeService{

    private GradeRepository repository = GradeRepository.getInstance();
    @Override
    public Grade createGrade(final Grade grade) {
        return repository.save(grade);
    }

    @Override
    public Grade updateGrade(final Grade grade) {
        return null;
    }

    @Override
    public List<Grade> getAllGrades() {
        return repository.findAll();
    }

    @Override
    public Grade getById(final String id) {
        return repository.findById(id);
    }

    @Override
    public void deleteGrade(final Grade grade) {
        repository.delete(grade);
    }
}
