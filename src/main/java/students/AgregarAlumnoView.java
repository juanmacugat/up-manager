package students;

import javax.swing.*;
import java.awt.*;

public class AgregarAlumnoView extends JFrame {

    private static final String TITLE = "Agregar alumno";

    public AgregarAlumnoView(){
        JLabel lblName = new JLabel("Nombre: ");
        JTextField txtName = new JTextField();
        JLabel lblLastname = new JLabel("Apellido: ");
        JTextField txtLastname = new JTextField();
        JLabel lblEmail = new JLabel("Email: ");
        JTextField txtEmail = new JTextField();
        JLabel lblBirthdate = new JLabel("Fecha de nacimiento: ");

        setLayout(new GridLayout(0,2));
        setTitle(TITLE);
        setPreferredSize(new Dimension(600,600));
        setVisible(true);

        getContentPane().add(lblName);
        getContentPane().add(txtName);
        getContentPane().add(lblLastname);
        getContentPane().add(txtLastname);
        getContentPane().add(lblEmail);
        getContentPane().add(txtEmail);
        getContentPane().add(lblBirthdate);


        pack();
    }
}
