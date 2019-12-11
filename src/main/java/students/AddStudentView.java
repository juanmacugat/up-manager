package students;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AddStudentView extends JFrame {

    private static final String TITLE = "Nuevo Alumno";
    private final StudentsPresenter presenter;

    private JPanel jPanelCenter, jPanelSouth;
    private JButton addButton, exitButton;
    private JTextField name, lastName, department, email, sex;


    public AddStudentView(final StudentsPresenter presenter){
        this.presenter = presenter;
        initialize();
    }

    private void initialize() {
        setTitle(TITLE);
        jPanelCenter = new JPanel();
        jPanelCenter.setLayout(new GridLayout(9, 2));
        jPanelCenter.add(new JLabel("nombre"));
        name = new JTextField();
        jPanelCenter.add(name);
        jPanelCenter.add(new JLabel("apellido"));
        lastName = new JTextField();
        jPanelCenter.add(lastName);
        jPanelCenter.add(new JLabel("sexo"));
        sex = new JTextField();
        jPanelCenter.add(sex);
        jPanelCenter.add(new JLabel("ciudad"));
        department = new JTextField();
        jPanelCenter.add(department);
        jPanelCenter.add(new JLabel("email"));
        email = new JTextField();
        jPanelCenter.add(email);
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
                    Student student = new Student(name.getText(), lastName.getText(), email.getText(), new Date(), new Date());
                    presenter.createStudent(student);
                    JOptionPane.showMessageDialog(null,
                            "Se dio de alta correctamente el alumno",
                            "Information", JOptionPane.INFORMATION_MESSAGE);
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

    private void clear() {
        name.setText("");
        lastName.setText("");
        sex.setText("");
        email.setText("");
        department.setText("");
    }

    private boolean check() {
        boolean result = false;
        if ("".equals(name.getText())  || "".equals(department.getText()) || "".equals(sex.getText()) || "".equals(email.getText())) {
            return result;
        } else {
            result = true;
        }
        return result;
    }

}
