package students;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlumnosListView extends JPanel {

    private final JList<Student> listView;
    private final JButton btnAgregar;

    public AlumnosListView(final StudentsModelList model, final AlumnoViewEditPanel viewEditPanel){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        listView = new JList<>(model);
        btnAgregar = new JButton("Agregar Alumno");
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                SwingUtilities.invokeLater(() ->{
                    AgregarAlumnoView view = new AgregarAlumnoView();
                });
            }
        });
        listView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listView.setLayoutOrientation(JList.VERTICAL);
        listView.setVisibleRowCount(-1);
        listView.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(final ListSelectionEvent e) {
                Student selectedStudent = model.getElementAt(listView.getSelectedIndex());
                viewEditPanel.updateView(selectedStudent);
            }
        });
        add(listView);
        add(btnAgregar);
    }

    public Student getSelectedStudent() {
return null;
    }
}
