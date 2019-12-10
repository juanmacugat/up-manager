package view;

import presenter.CoursesPresenter;

import javax.swing.*;
import java.awt.*;

public class CoursesView{

    private static final String[] HEADERS = {"Id","Name","Teacher"};

    private CoursesPresenter presenter;

    private JFrame frame;
    private JButton newButton;
    private JButton cancelButton;
    private JButton editButton;
    private JTable courseTable;

    public CoursesView(String title){
        initialize(title);
    }

    public CoursesView() {

    }

    private void initialize(String title) {

        courseTable = new JTable();
        editButton = new JButton("EDIT");
        editButton.addActionListener(event -> {

        });
        newButton = new JButton("ADD");
        newButton.addActionListener(event->{

        });

        cancelButton = new JButton("CANCEL");
        cancelButton.addActionListener(event ->{
            frame.setVisible(false);
            System.exit(0);
        });

        frame =  new JFrame(title);
        frame.setLocationRelativeTo(null);

        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(new GridLayout(0,1,3,3));
        frame.getContentPane().add(courseTable);
        frame.getContentPane().add(newButton);
        frame.getContentPane().add(cancelButton);

        frame.pack();
        frame.setVisible(true);
    }


    public void setPresenter(final CoursesPresenter presenter) {
        this.presenter = presenter;
    }

    public JTable getCourseTable() {
        return courseTable;
    }
}
