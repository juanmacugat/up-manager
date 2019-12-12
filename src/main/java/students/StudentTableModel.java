package students;

import javax.swing.table.AbstractTableModel;

public class StudentTableModel extends AbstractTableModel {

    private StudentRepository repository = StudentRepository.getInstance();

    String headers[] = new String[]{"ID", "NOMBRE", "APELLIDO", "EMAIL", "FECHA DE NACIMIENTO", "FECHA DE CREACION"};


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
            case 4:
                return student.getBirthdate();
            case 5:
                return student.getCreationDate();
            default:
                return null;
        }
    }

    public String getColumnName(int col) {
        return headers[col];
    }

    public Student elementAt(final int row) {
        return repository.findAll().get(row);
    }
}
