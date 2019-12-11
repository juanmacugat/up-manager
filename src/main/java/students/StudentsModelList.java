package students;

import javax.swing.*;

public class StudentsModelList extends DefaultListModel<Student> {

    private StudentRepository repository = StudentRepository.getInstance();

    private static StudentsModelList instance= new StudentsModelList();

    public static StudentsModelList getInstance(){
        return instance;
    }

    private StudentsModelList(){

    }

    @Override
    public int getSize() {
        return repository.findAll().size();
    }

    @Override
    public Student getElementAt(final int index) {
        return repository.findAll().get(index);
    }
}
