package students;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewStudentsView  extends JPanel {

	private final StudentTableModel model;
	private JTextField txtSearch;
	private JTable tblStudents;
	private StudentsPresenter presenter;

	public NewStudentsView() {
		setLayout(new BorderLayout(0, 0));

		JPanel south = new JPanel();
		add(south, BorderLayout.SOUTH);

		JButton btnAdd = new JButton("agregar");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				new AddStudentView(presenter);
			}
		});
		south.add(btnAdd);

		JButton btnEdit = new JButton("editar");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				new EditStudentView(getSelectedStudent(), presenter);
			}
		});
		south.add(btnEdit);

		JButton btnDelete = new JButton("borrar");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				presenter.deleteStudent(getSelectedStudent());
				JOptionPane.showMessageDialog(null,
						"Se elimino el curso correctamente",
						"Information", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		south.add(btnDelete);

		JPanel north = new JPanel();
		add(north, BorderLayout.NORTH);
		north.setLayout(new BorderLayout(0, 0));

		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		north.add(txtSearch, BorderLayout.CENTER);

		JButton btnSearch = new JButton("buscar");
		north.add(btnSearch, BorderLayout.EAST);

		model = new StudentTableModel();
		tblStudents = new JTable(model);

		tblStudents.setAutoCreateColumnsFromModel(true);
		tblStudents.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(tblStudents);
		add(scrollPane, BorderLayout.CENTER);
	}

	private Student getSelectedStudent() {
		int selectedRow = tblStudents.getSelectedRow();
		return model.elementAt(selectedRow);
	}

	public void setPresenter(final StudentsPresenter presenter) {
		this.presenter = presenter;
	}

	public void update() {
		model.fireTableDataChanged();
	}
}
