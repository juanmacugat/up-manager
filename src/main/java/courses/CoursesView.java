package courses;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoursesView extends JPanel{

    private CoursesPresenter presenter;
    private CoursesModelList model;
    private JList<Course> coursesList;

    public CoursesView() {
        initialize();
    }

    private void initialize() {
        setLayout(new GridLayout(0,2));
        JPanel leftPanel = leftPanel();
        JPanel rightPanel = rightPanel();
        add(leftPanel);
//        add(rightPanel);
    }

    private JPanel rightPanel() {
        return null;
    }

    private JPanel leftPanel() {
        model = CoursesModelList.getInstance();
        coursesList = new JList<>(model);
        coursesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(final ListSelectionEvent e) {
                Course selectedCourse = model.getElementAt(coursesList.getSelectedIndex());
                update(selectedCourse);
            }
        });
        JPanel panelListado = new JPanel(new GridLayout(2,0));
        JButton btnAddCourse = new JButton("+ curso");
        btnAddCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                AddCourseView view = new AddCourseView(presenter);
            }
        });
        panelListado.add(coursesList);
        panelListado.add(btnAddCourse);
        return panelListado;
    }

    public void setPresenter(final CoursesPresenter presenter) {
        this.presenter = presenter;
    }

    public void clear() {

    }

    public void update(final Course course) {
        model.addElement(course);
    }
}
