package view;

import lombok.Getter;
import lombok.Setter;
import domain.Student;
import presenter.StudentsPresenter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
@Setter
public class StudentsView {

    private StudentsPresenter presenter;

    private JFrame frame;
    private JTable studentsTable;
    private JButton newButton;
    private JButton cancelButton;
    private JButton editButton;
    private DefaultTableModel studentsModel;

    public StudentsView(String title){
        initialize(title);
    }

    private void initialize(String title){
        frame = new JFrame(title);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setPreferredSize(new Dimension(600,600));

        newButton = new JButton("ADD");
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        editButton = new JButton("EDIT");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cancelButton = new JButton("CANCEL");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        studentsTable = new JTable();

        frame.getContentPane().add(studentsTable);
        frame.getContentPane().add(newButton);
        frame.getContentPane().add(cancelButton);
        frame.getContentPane().add(editButton);

        frame.setVisible(true);
        frame.pack();
    }

}
