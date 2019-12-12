package grades;

import java.util.List;

public interface GradeService {

    Grade createGrade(Grade grade);

    Grade updateGrade(Grade grade);

    List<Grade> getAllGrades();

    Grade getById(String id);

    void deleteGrade(Grade grade);
}
