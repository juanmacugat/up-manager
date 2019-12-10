package presenter;

import domain.Course;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import service.CourseService;
import service.CourseServiceImpl;
import view.CoursesView;

import java.util.List;

import static org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ;

public class CoursesPresenter {

    private CoursesView view;
    private CourseService courseService = new CourseServiceImpl();

    public CoursesPresenter(CoursesView view) {
        JTableBinding tb = SwingBindings.createJTableBinding(READ, getAllCourses(), view.getCourseTable());

        BeanProperty id = BeanProperty.create("id");
        BeanProperty name = BeanProperty.create("name");
        BeanProperty teacher = BeanProperty.create("teacher");

        tb.addColumnBinding(id).setColumnName("Id").setColumnClass(String.class);
        tb.addColumnBinding(name).setColumnName("Name").setColumnClass(String.class);
        tb.addColumnBinding(teacher).setColumnName("Teacher").setColumnClass(String.class);

        tb.bind();
    }

    public List<Course> getAllCourses() {
        return courseService.findAllCourses();
    }
}
