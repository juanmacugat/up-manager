package view;

import lombok.Getter;
import lombok.Setter;
import domain.Student;
import presenter.StudentsPresenter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Getter
@Setter
public class StudentsView {

    private StudentsPresenter presenter;

    private JFrame frame;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JTextField nameText;
    private JTextField surnameText;
    private JButton saveButton;
    private JTable studentsTable;
    private DefaultTableModel studentsModel;

    public StudentsView(String title){
        initialize(title);
    }

    private void initialize(String title){
        frame = new JFrame(title);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setPreferredSize(new Dimension(600,600));

        studentsTable = new JTable();

        frame.setVisible(true);
        frame.pack();
    }

}
