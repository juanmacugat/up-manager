package enrollments;

import courses.Course;
import courses.CourseRepository;
import students.Student;
import students.StudentRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EnrollmentView extends JPanel{

	private JTextField txtSearch;
	private EnrollmentPresenter presenter;
	private JTable tblEnrollments;
	private EnrollmentTableModel model;
	private JComboBox cmbSubjects;
	private JComboBox cmbStudents;

	public EnrollmentView() {
		initialize();
	}

	public void initialize() {
		setLayout(new BorderLayout(0, 0));

		JPanel north = new JPanel();
		add(north, BorderLayout.NORTH);
		north.setLayout(new BorderLayout(0, 0));

		txtSearch = new JTextField();
		north.add(txtSearch, BorderLayout.CENTER);
		txtSearch.setColumns(10);

		JButton btnSearch = new JButton("buscar");
		north.add(btnSearch, BorderLayout.EAST);

		model = new EnrollmentTableModel();
		tblEnrollments = new JTable(model);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(tblEnrollments);
		add(scrollPane, BorderLayout.CENTER);

		JPanel south = new JPanel();
		add(south, BorderLayout.SOUTH);

		List<Student> students = StudentRepository.getInstance().findAll();
		cmbStudents = new JComboBox(students.toArray());
		south.add(cmbStudents);

		List<Course> courses = CourseRepository.getInstance().findAll();
		cmbSubjects = new JComboBox(courses.toArray());
		south.add(cmbSubjects);

		JButton btnEnroll = new JButton("inscribir");
		btnEnroll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {

				int studentIndex = cmbStudents.getSelectedIndex();
				int courseIndex = cmbSubjects.getSelectedIndex();

				Student student = StudentRepository.getInstance().findAll().get(studentIndex);
				Course course = CourseRepository.getInstance().findAll().get(courseIndex);

				presenter.create(new Enrollment(course.getId(),student.getId()));
			}
		});
		south.add(btnEnroll);

		JButton btnUnroll = new JButton("dar de baja");
		btnUnroll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				presenter.delete(getSelectedEnrollment());
			}
		});
		south.add(btnUnroll);
	}

	private Enrollment getSelectedEnrollment() {
		int selectedRow = tblEnrollments.getSelectedRow();
		return model.elementAt(selectedRow);
	}

	public void setPresenter(final EnrollmentPresenter presenter) {
		this.presenter = presenter;
	}

	public void update() {
		model.fireTableDataChanged();
		cmbSubjects.setModel(new DefaultComboBoxModel(CourseRepository.getInstance().findAll().toArray()));
		cmbStudents.setModel(new DefaultComboBoxModel(StudentRepository.getInstance().findAll().toArray()));
	}


}
