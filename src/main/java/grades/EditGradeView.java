package grades;

import courses.Course;
import enrollments.EnrollmentRepository;
import students.Student;
import students.StudentRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EditGradeView extends JFrame{

    private static final String TITLE = "Actualizar calificacion";

    private final GradesPresenter presenter;
    private final Grade grade;
    private JComboBox cmbSubjects;
    private JComboBox cmbStudents;
    private JComboBox cmbGrades;

    public EditGradeView(final Grade grade, final GradesPresenter presenter) {
        this.presenter = presenter;
        this.grade = grade;
        initialize();
    }

    private void initialize() {
        setTitle(TITLE);
        JPanel south = new JPanel();
        getContentPane().add(south, BorderLayout.SOUTH);

        JButton btnConfirm = new JButton("editar");
        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                grade.setGrade(Integer.parseInt((String)cmbGrades.getSelectedItem()));
                presenter.update(grade);
                JOptionPane.showMessageDialog(null,
                        "Se modifico la calificacion correctamente",
                        "Information", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });
        south.add(btnConfirm);

        JButton btnExit = new JButton("salir");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                dispose();
            }
        });
        south.add(btnExit);

        JPanel center = new JPanel();
        getContentPane().add(center, BorderLayout.CENTER);
        center.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblStudent = new JLabel("Seleccionar alumno:");
        lblStudent.setHorizontalAlignment(SwingConstants.CENTER);
        center.add(lblStudent);

        Set<Student> students = EnrollmentRepository.getInstance().findAll().stream()
                .map(enrollment -> enrollment.getStudent_id())
                .map(id -> StudentRepository.getInstance().findById(id)).collect(Collectors.toSet());
        cmbStudents = new JComboBox(students.toArray());
        cmbStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                Student student = (Student)cmbStudents.getSelectedItem();
                update(student);
            }
        });
        center.add(cmbStudents);

        JLabel lblCourse = new JLabel("Seleccionar curso:");
        lblCourse.setHorizontalAlignment(SwingConstants.CENTER);
        center.add(lblCourse);

        List<Course> courses = EnrollmentRepository.getInstance().findCoursesByStudent(students.stream().findFirst().get());
        cmbSubjects = new JComboBox(courses.toArray());
        center.add(cmbSubjects);

        JLabel lblGrade = new JLabel("Calificar:");
        lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
        center.add(lblGrade);

        cmbGrades = new JComboBox();
        cmbGrades.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
        center.add(cmbGrades);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(470, 200, 400, 270);
        setResizable(false);
        setVisible(true);
    }

    private void update(final Student student) {
        cmbSubjects.setModel(new DefaultComboBoxModel(EnrollmentRepository.getInstance().findCoursesByStudent(student).toArray()));
    }
}
