package courses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoursesView extends JPanel{
	private final CoursesTableModel model;
	private JTextField txtSearch;
	private CoursesPresenter presenter;
	private JTable tblCourses;

	public CoursesView() {

		setLayout(new BorderLayout());

		JPanel south = new JPanel();
		add(south, BorderLayout.SOUTH);

		JButton btnAdd = new JButton("agregar");
		south.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				new AddCourseView(presenter);
			}
		});

		JButton btnEdit = new JButton("editar");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				new EditCourseView(getSelectedCourse(), presenter);
			}
		});
		south.add(btnEdit);

		JButton btnDelete = new JButton("borrar");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				presenter.delete(getSelectedCourse());
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
		north.add(txtSearch, BorderLayout.CENTER);
		txtSearch.setColumns(10);

		JButton btnSearch = new JButton("buscar");
		north.add(btnSearch, BorderLayout.EAST);

		model = new CoursesTableModel();
		tblCourses = new JTable(model);
		tblCourses.setAutoCreateColumnsFromModel(true);
		tblCourses.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(tblCourses);
		add(scrollPane, BorderLayout.CENTER);
	}

	private Course getSelectedCourse() {
		int selectedRow = tblCourses.getSelectedRow();
		return model.elementAt(selectedRow);
	}

	public void setPresenter(final CoursesPresenter presenter) {
		this.presenter = presenter;
	}

	public void update() {
		model.fireTableDataChanged();
	}

}
