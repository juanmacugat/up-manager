package students;

import students.Student;
import students.StudentsPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlumnoViewEditPanel extends JPanel {

    JTextField name = new JTextField();
    JTextField txtLastname = new JTextField();
    JTextField txtEmail = new JTextField();

    public AlumnoViewEditPanel(final StudentsPresenter presenter){

        setLayout(new GridLayout(0,2));
        add(new JLabel("Nombre: "));
        add(name);
        add(new JLabel("Apellido: "));
        add(txtLastname);
        add(new JLabel("Email: "));
        add(txtEmail);
        add(new JLabel("Fecha de nacimiento: "));
        add(new JTextField());

        JButton btnSave = new JButton("Editar");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {

            }
        });
        JButton btnDelete = new JButton("Eliminar");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                presenter.deleteStudent(getSelectedStudent());
                JOptionPane.showMessageDialog(null,
                        "Alumno eliminado");
            }
        });

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(0, 2));
        btnPanel.add(btnDelete);
        btnPanel.add(btnSave);
        add(btnPanel);

    }

    private Student getSelectedStudent() {
        return null;
    }

    public void updateView(final Student student){
        clearAll();
        name.setText(student.getName());
        txtLastname.setText(student.getSurname());
        txtEmail.setText(student.getEmail());
    }

    private void clearAll() {
        name.setText("");
        txtLastname.setText("");
        txtEmail.setText("");
    }
}
