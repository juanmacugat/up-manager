package students;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class EditStudentView extends JFrame {

    private static final String TITLE = "Editar alumno";
    private final StudentsPresenter presenter;
    private final Student student;

    private JPanel center, south;
    private JButton addButton, exitButton;
    private JTextField txtName, txtLastname, txtBirthdate, txtEmail;


    public EditStudentView(final Student student, final StudentsPresenter presenter) {
        this.presenter = presenter;
        this.student = student;
        initialize();
    }

    private void initialize() {
        setTitle(TITLE);
        center = new JPanel();
        center.setLayout(new GridLayout(6, 2));
        JLabel lblName = new JLabel("nombre");
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        center.add(lblName);
        txtName = new JTextField(student.getName());
        center.add(txtName);
        JLabel lblLastname = new JLabel("apellido");
        lblLastname.setHorizontalAlignment(SwingConstants.CENTER);
        center.add(lblLastname);
        txtLastname = new JTextField(student.getSurname());
        center.add(txtLastname);
        JLabel lblBirthdate = new JLabel("fecha de nacimiento");
        lblBirthdate.setHorizontalAlignment(SwingConstants.CENTER);
        center.add(lblBirthdate);
        txtBirthdate = new JTextField(student.getBirthdate().toString());
        center.add(txtBirthdate);
        JLabel lblEmail = new JLabel("email");
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
        center.add(lblEmail);
        txtEmail = new JTextField(student.getEmail());
        center.add(txtEmail);
        center.add(new JSeparator(SwingConstants.HORIZONTAL));
        center.add(new JSeparator(SwingConstants.HORIZONTAL));

        // south panel
        south = new JPanel();
        south.setLayout(new GridLayout(1, 2));
        addButton = new JButton("confirmar");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (check()) {
                    student.setName(txtName.getText());
                    student.setSurname(txtLastname.getText());
                    student.setEmail(txtEmail.getText());
                    student.setBirthdate(LocalDate.parse(txtBirthdate.getText()));
                    presenter.updateStudent(student);
                    JOptionPane.showMessageDialog(null,
                            "Se actualizo correctamente el alumno",
                            "Information", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
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
                "Se actualizo correctamente el alumno",
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
