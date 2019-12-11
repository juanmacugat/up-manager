package courses;

import javax.swing.*;

public class CoursesModelList extends AbstractListModel<Course> {

    private static CoursesModelList instance = new CoursesModelList();

    private CoursesModelList(){
    }

    public static CoursesModelList getInstance() {
        return instance;
    }

    @Override
    public int getSize() {
        return 10;
    }

    @Override
    public Course getElementAt(final int index) {
        return null;
    }
}
