package grades;

import students.Student;
import students.StudentsModelList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradesView extends JPanel {
	private GradesPresenter presenter;
	private JTextField txtSearch;
	private JTextField txtName;
	private JTextField txtLastname;
	private JTextField txtEmail;

	public void setPresenter(final GradesPresenter presenter) {
		this.presenter = presenter;
	}

	public GradesView(){
		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JPanel south = new JPanel();
		add(south, BorderLayout.SOUTH);

		JButton btnAdd = new JButton("agregar");
		south.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				AddGradeView view = new AddGradeView(presenter);
			}
		});

		JButton btnEdit = new JButton("editar");
		south.add(btnEdit);

		JButton btnDelete = new JButton("borrar");
		south.add(btnDelete);

		JPanel north = new JPanel();
		add(north, BorderLayout.NORTH);
		north.setLayout(new BorderLayout(0, 0));

		JButton btnSearch = new JButton("buscar");
		north.add(btnSearch, BorderLayout.EAST);

		txtSearch = new JTextField();
		north.add(txtSearch, BorderLayout.CENTER);
		txtSearch.setColumns(10);

		JPanel east = new JPanel();
		add(east, BorderLayout.EAST);
		east.setLayout(new BorderLayout(0, 0));

		JPanel pnlEdit = new JPanel();
		east.add(pnlEdit, BorderLayout.NORTH);
		pnlEdit.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblName = new JLabel("Nombre:");
		pnlEdit.add(lblName);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);

		txtName = new JTextField();
		pnlEdit.add(txtName);
		txtName.setColumns(10);

		JLabel lblLastname = new JLabel("Apellido:");
		pnlEdit.add(lblLastname);
		lblLastname.setHorizontalAlignment(SwingConstants.CENTER);

		txtLastname = new JTextField();
		pnlEdit.add(txtLastname);
		txtLastname.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		pnlEdit.add(lblEmail);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);

		txtEmail = new JTextField();
		pnlEdit.add(txtEmail);
		txtEmail.setColumns(10);

		StudentsModelList model = StudentsModelList.getInstance();
		JList lstGrades = new JList(model);

		lstGrades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstGrades.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(final ListSelectionEvent e) {
				Student selectedStudent = model.getElementAt(lstGrades.getSelectedIndex());
				updateSelectedStudent(selectedStudent);
			}
		});

		add(lstGrades, BorderLayout.CENTER);
	}

	private void updateSelectedStudent(final Student student) {
		txtName.setText(student.getName());
		txtLastname.setText(student.getSurname());
		txtEmail.setText(student.getEmail());
	}
}
