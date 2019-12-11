package courses;

import courses.Course;
import courses.CourseRepository;

import javax.swing.table.AbstractTableModel;

public class CoursesTableModel extends AbstractTableModel {

    private static CourseRepository repository = CourseRepository.getInstance();

    String headers[] = new String[]{"id", "nombre", "profesor", "facultad", "condicion aprobacion"};


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
        Course course = repository.findAll().get(row);
        switch(column){
            case 0:
                return course.getId();
            case 1:
                return course.getName();
            case 2:
                return course.getTeacher();
            case 3:
                return course.getMajor();
            case 4:
                return course.getPass_condition();
            default:
                return null;
        }
    }

    public String getColumnName(int col) {
        return headers[col];
    }

    public Course elementAt(final int row) {
        return repository.findAll().get(row);
    }

}
