package students;

import javax.swing.*;
import java.util.Date;

public class StudentsModelList extends AbstractListModel<Student> {

//    private StudentRepository repository = StudentRepository.getInstance();

    private static StudentsModelList instance= new StudentsModelList();

    public static StudentsModelList getInstance(){
        return instance;
    }

    private StudentsModelList(){

    }

    @Override
    public int getSize() {
        return 10;
    }

    @Override
    public Student getElementAt(final int index) {
        return null;
    }
}
