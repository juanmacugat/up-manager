package students;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class AddStudentView extends JFrame {

    private static final String TITLE = "Nuevo Alumno";
    private final StudentsPresenter presenter;

    private JPanel center, south;
    private JButton addButton, exitButton;
    private JTextField txtName, txtLastname, txtBirthdate, txtEmail;


    public AddStudentView(final StudentsPresenter presenter){
        this.presenter = presenter;
        initialize();
    }

    private void initialize() {
        setTitle(TITLE);
        center = new JPanel();
        center.setLayout(new GridLayout(6, 2));
        JLabel lblName = new JLabel("nombre");
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        center.add(lblName);
        txtName = new JTextField();
        center.add(txtName);
        JLabel lblLastname = new JLabel("apellido");
        lblLastname.setHorizontalAlignment(SwingConstants.CENTER);
        center.add(lblLastname);
        txtLastname = new JTextField();
        center.add(txtLastname);
        JLabel lblBirthdate = new JLabel("fecha de nacimiento");
        lblBirthdate.setHorizontalAlignment(SwingConstants.CENTER);
        center.add(lblBirthdate);
        txtBirthdate = new JTextField();
        center.add(txtBirthdate);
        JLabel lblEmail = new JLabel("email");
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
        center.add(lblEmail);
        txtEmail = new JTextField();
        center.add(txtEmail);
        center.add(new JSeparator(SwingConstants.HORIZONTAL));
        center.add(new JSeparator(SwingConstants.HORIZONTAL));

        // south panel
        south = new JPanel();
        south.setLayout(new GridLayout(1, 2));
        addButton = new JButton("agregar");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (check()) {
                    Student student = new Student(txtName.getText(), txtLastname.getText(), txtEmail.getText(), LocalDate.parse(txtBirthdate.getText()), LocalDate.now());
                    presenter.create(student);
                    showDialog();
                    dispose();
                }
            }
        });
        south.add(addButton);
        exitButton = new JButton("salir");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        south.add(exitButton);

        getContentPane().add(center, BorderLayout.CENTER);
        getContentPane().add(south, BorderLayout.SOUTH);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(470, 200, 400, 270);
        setResizable(false);
        setVisible(true);
    }

    private void showDialog() {
        JOptionPane.showMessageDialog(null,
                "Se dio de alta correctamente el alumno",
                "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean check() {
        boolean result = false;
        if ("".equals(txtName.getText())) {
            return result;
        } else {
            result = true;
        }
        return result;
    }

}
