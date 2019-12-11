package courses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCourseView extends JFrame {

    private static final String TITLE = "Nuevo Curso";
    private final CoursesPresenter presenter;

    private JPanel jPanelCenter, jPanelSouth;
    private JButton addButton, exitButton;
    private JTextField name, subject, teacher;


    public AddCourseView(final CoursesPresenter presenter){
        this.presenter = presenter;
        initialize();
    }

    private void initialize() {
        setTitle(TITLE);
        jPanelCenter = new JPanel();
        jPanelCenter.setLayout(new GridLayout(4, 2));
        jPanelCenter.add(new JLabel("nombre"));
        name = new JTextField();
        jPanelCenter.add(name);
        jPanelCenter.add(new JLabel("codigo materia"));
        subject = new JTextField();
        jPanelCenter.add(subject);
        jPanelCenter.add(new JLabel("profesor"));
        teacher = new JTextField();
        jPanelCenter.add(teacher);
        jPanelCenter.add(new JSeparator(SwingConstants.HORIZONTAL));
        jPanelCenter.add(new JSeparator(SwingConstants.HORIZONTAL));

        // south panel
        jPanelSouth = new JPanel();
        jPanelSouth.setLayout(new GridLayout(1, 2));
        addButton = new JButton("agregar");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (check()) {
                    Course course = new Course(name.getText());
                    presenter.createCourse(course);
                    showDialog();
                    dispose();
                }
            }
        });
        jPanelSouth.add(addButton);
        exitButton = new JButton("salir");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        jPanelSouth.add(exitButton);

        this.add(jPanelCenter, BorderLayout.CENTER);
        this.add(jPanelSouth, BorderLayout.SOUTH);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(470, 200, 400, 270);
        setResizable(false);
        setVisible(true);
    }

    private void showDialog() {
        JOptionPane.showMessageDialog(null,
                "Se dio de alta correctamente el curso",
                "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    private void clear() {
        name.setText("");
        subject.setText("");
        teacher.setText("");
    }

    private boolean check() {
        boolean result = false;
        if ("".equals(name.getText())  || "".equals(teacher.getText())) {
            return result;
        } else {
            result = true;
        }
        return result;
    }

}
