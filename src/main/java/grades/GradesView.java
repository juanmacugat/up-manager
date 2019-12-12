package grades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradesView extends JPanel {
	private GradesPresenter presenter;
	private JTextField txtSearch;
	private JTable tblGrades;
	private GradesTableModel model;

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
				new AddGradeView(presenter);
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

		model = new GradesTableModel();
		tblGrades = new JTable(model);
		
		JScrollPane center = new JScrollPane();
		add(center, BorderLayout.CENTER);
		center.setViewportView(tblGrades);
	}

	public void update() {
		model.fireTableDataChanged();
	}
}
