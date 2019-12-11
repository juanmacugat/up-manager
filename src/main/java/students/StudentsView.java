package students;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentsView extends JPanel {

    private StudentsPresenter presenter;
    private JTextField txtBirthdate,txtName,txtLastname,txtEmail;
    private StudentsModelList model;
    private JList<Student> studentList;
    public StudentsView(){
        initialize();
    }

    private void initialize() {
        setLayout(new GridLayout(0,2));
        JPanel leftPanel = leftPanel();
        JPanel rightPanel = rightPanel();
        add(leftPanel);
        add(rightPanel);
    }

    private JPanel rightPanel() {
        txtName = new JTextField();
        txtLastname = new JTextField();
        txtEmail = new JTextField();
        txtBirthdate = new JTextField();
        JButton btnEdit = new JButton("* editar");
        JButton btnDelete = new JButton("* eliminar");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                Student student = model.getElementAt(studentList.getSelectedIndex());
                presenter.deleteStudent(student);
            }
        });

        JPanel panelEdicion = new JPanel(new GridLayout(0,2));
        panelEdicion.add(new JLabel("Nombre: "));
        panelEdicion.add(txtName);
        panelEdicion.add(new JLabel("Apellido: "));
        panelEdicion.add(txtLastname);
        panelEdicion.add(new JLabel("Email: "));
        panelEdicion.add(txtEmail);
        panelEdicion.add(new JLabel("Fecha de nacimiento: "));
        panelEdicion.add(txtBirthdate);
        panelEdicion.add(btnEdit);
        panelEdicion.add(btnDelete);
        return panelEdicion;
    }

    private JPanel leftPanel() {
        model = StudentsModelList.getInstance();
        studentList = new JList<>(model);
        studentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        studentList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(final ListSelectionEvent e) {
                Student selectedStudent = model.getElementAt(studentList.getSelectedIndex());
                updateSelectedStudent(selectedStudent);
            }
        });
        JPanel panelListado = new JPanel(new GridLayout(2,0));
        JButton btnAgregarAlumno = new JButton("+ alumno");
        btnAgregarAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                AddStudentView view = new AddStudentView(presenter);
            }
        });
        panelListado.add(studentList);
        panelListado.add(btnAgregarAlumno);
        return panelListado;
    }

    private void updateSelectedStudent(final Student student) {
        txtName.setText(student.getName());
        txtLastname.setText(student.getSurname());
        txtEmail.setText(student.getEmail());
    }

    public void clear() {

    }

    public void setPresenter(final StudentsPresenter presenter) {
        this.presenter = presenter;
    }

    public void update(final Student student) {
        model.addElement(student);
    }
}
