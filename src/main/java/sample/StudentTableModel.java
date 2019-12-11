package sample;

import students.Student;
import students.StudentRepository;

import javax.swing.table.AbstractTableModel;

public class StudentTableModel extends AbstractTableModel {

    private StudentRepository repository = StudentRepository.getInstance();

    String headers[] = new String[]{"id", "name", "lastname", "email"};


@Override
    public int getRowCount() {
        return repository.findAll().size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(final int row, final int column) {
        Student student = repository.findAll().get(row);
        switch (column){
            case 0:
                return student.getId();
            case 1:
                return student.getName();
            case 2:
                return student.getSurname();
            case 3:
                return student.getEmail();
            default:
                return null;
        }
    }
}
