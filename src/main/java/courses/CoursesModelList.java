package courses;

import javax.swing.*;

public class CoursesModelList extends DefaultListModel<Course> {


    private static CourseRepository repository = CourseRepository.getInstance();
    private static CoursesModelList instance = new CoursesModelList();

    private CoursesModelList(){
    }

    public static CoursesModelList getInstance() {
        return instance;
    }

    @Override
    public int getSize() {
        return repository.findAll().size();
    }

    @Override
    public Course getElementAt(final int index) {
        return repository.findAll().get(index);
    }
}
