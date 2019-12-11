package courses;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class CoursesView extends JPanel{

    private CoursesPresenter presenter;

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
        CoursesModelList model = CoursesModelList.getInstance();
        JList<Course> coursesList = new JList<>(model);
        coursesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(final ListSelectionEvent e) {
                Course selectedCourse = model.getElementAt(coursesList.getSelectedIndex());
                updateView(selectedCourse);
            }
        });
        JPanel panelListado = new JPanel(new GridLayout(2,0));
        JButton btnAgregarAlumno = new JButton("+ curso");
        panelListado.add(coursesList);
        panelListado.add(btnAgregarAlumno);
        return panelListado;
    }

    private void updateView(final Course course) {

    }

    public void setPresenter(final CoursesPresenter presenter) {
        this.presenter = presenter;
    }

}
