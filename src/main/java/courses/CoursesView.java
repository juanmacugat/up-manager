package courses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoursesView extends JPanel{
	private JTextField txtSearch;
	private CoursesPresenter presenter;

	public CoursesView() {

		setLayout(new BorderLayout());
		
		JPanel south = new JPanel();
		add(south, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("agregar");
		south.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				AddCourseView view = new AddCourseView(presenter);
			}
		});
		
		JButton btnEdit = new JButton("editar");
		south.add(btnEdit);
		
		JButton btnDelete = new JButton("borrar");
		south.add(btnDelete);
		
		JPanel north = new JPanel();
		add(north, BorderLayout.NORTH);
		north.setLayout(new BorderLayout(0, 0));
		
		txtSearch = new JTextField();
		north.add(txtSearch, BorderLayout.CENTER);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("buscar");
		north.add(btnSearch, BorderLayout.EAST);
		
		JList lstCourses = new JList();
		add(lstCourses, BorderLayout.CENTER);
	}

	public void setPresenter(final CoursesPresenter presenter) {
		this.presenter = presenter;
	}

	public void update(final Course course) {

	}

	public void clear() {

	}
}
