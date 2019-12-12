package enrollments;

import courses.CourseRepository;
import students.StudentRepository;

import javax.swing.table.AbstractTableModel;

public class EnrollmentTableModel extends AbstractTableModel {

    private EnrollmentRepository repository = EnrollmentRepository.getInstance();

    String headers[] = new String[]{"ID", "ALUMNO", "CURSO"};

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
        Enrollment enrollment = repository.findAll().get(row);
        switch (column){
            case 0:
                return enrollment.getId();
            case 1:
                return StudentRepository.getInstance().findById(enrollment.getStudent_id());
            case 2:
                return CourseRepository.getInstance().findById(enrollment.getCourse_id());
            default:
                return null;
        }
    }

    public String getColumnName(int col) {
        return headers[col];
    }

    public Enrollment elementAt(final int row) {
        return repository.findAll().get(row);
    }
}
