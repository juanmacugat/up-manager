package grades;

import courses.Course;
import courses.CourseRepository;
import students.Student;
import students.StudentRepository;

import javax.swing.table.AbstractTableModel;

public class GradesTableModel extends AbstractTableModel {

    private GradeRepository repository = GradeRepository.getInstance();

    String headers[] = new String[]{"ID", "ALUMNO", "CURSO", "NOTA", "ESTADO"};

    @Override
    public int getRowCount() {
        return repository.findAll().size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(final int row, final int column) {
        Grade grade = repository.findAll().get(row);
        Student student = StudentRepository.getInstance().findById(grade.getStudent_id());
        Course course = CourseRepository.getInstance().findById(grade.getCourse_id());
        switch(column){
            case 0:
                return grade.getId();
            case 1:
                return student;
            case 2:
                return course;
            case 3:
                return grade.getGrade();
            case 4:
                if(grade.getGrade() >= course.getPass_condition()){
                    return "APROBADO";
                }else{
                    return "DESAPROBADO";
                }
            default:
                return null;
        }
    }

    public String getColumnName(int col) {
        return headers[col];
    }

    public Grade elementAt(final int row) {
        return repository.findAll().get(row);
    }

}
