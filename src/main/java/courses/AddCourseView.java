package courses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCourseView extends JFrame {

    private static final String TITLE = "Nuevo Curso";
    private final CoursesPresenter presenter;
    private JPanel south;
    private JButton btnCancel;
    private JButton btnConfirm;
    private JPanel center;
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblTeacher;
    private JLabel lblMajor;
    private JTextField txtTeacher;
    private JComboBox cmbMajor;
    private JLabel lblCondition;
    private JComboBox cmbCondition;


    public AddCourseView(final CoursesPresenter presenter){
        this.presenter = presenter;
        
        south = new JPanel();
        getContentPane().add(south, BorderLayout.SOUTH);
        
        btnConfirm = new JButton("confirmar");
        south.add(btnConfirm);
        
        btnCancel = new JButton("cancelar");
        south.add(btnCancel);
        
        center = new JPanel();
        getContentPane().add(center, BorderLayout.CENTER);
        center.setLayout(new GridLayout(4, 2, 0, 0));
        
        lblName = new JLabel("Nombre:");
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        center.add(lblName);
        
        txtName = new JTextField();
        center.add(txtName);
        txtName.setColumns(10);
        
        lblTeacher = new JLabel("Docente a cargo:");
        lblTeacher.setHorizontalAlignment(SwingConstants.CENTER);
        center.add(lblTeacher);
        
        txtTeacher = new JTextField();
        center.add(txtTeacher);
        txtTeacher.setColumns(10);
        
        lblMajor = new JLabel("Facultad:");
        lblMajor.setHorizontalAlignment(SwingConstants.CENTER);
        center.add(lblMajor);
        
        cmbMajor = new JComboBox();
        center.add(cmbMajor);
        
        lblCondition = new JLabel("Condicion de aprobacion:");
        lblCondition.setHorizontalAlignment(SwingConstants.CENTER);
        center.add(lblCondition);
        
        cmbCondition = new JComboBox();
        center.add(cmbCondition);
        initialize();
    }

    private void initialize() {
        setTitle(TITLE);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(470, 200, 400, 270);
        setResizable(false);
        setVisible(true);
    }

    private void showDialog() {
        JOptionPane.showMessageDialog(null,
                "Se dio de alta correctamente la materia",
                "Information", JOptionPane.INFORMATION_MESSAGE);
    }

}
