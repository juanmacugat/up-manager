package grades;

import utils.Service;

import java.util.List;

public class GradeService extends Service<Grade> {

    private GradeRepository repository = GradeRepository.getInstance();
    @Override
    public Grade create(final Grade grade) {
        return repository.save(grade);
    }

    @Override
    public Grade update(final Grade grade) {
        repository.update(grade);
        return grade;
    }

    @Override
    public List<Grade> findAll() {
        return repository.findAll();
    }

    @Override
    public Grade findById(final String id) {
        return repository.findById(id);
    }

    @Override
    public void delete(final Grade grade) {
        repository.delete(grade);
    }
}
