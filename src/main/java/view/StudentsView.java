package view;

import lombok.Getter;
import lombok.Setter;
import domain.Student;
import presenter.StudentsPresenter;

import javax.swing.*;
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

    public StudentsView(String title){
        frame = new JFrame(title);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setPreferredSize(new Dimension(600,600));
        frame.setVisible(true);
        frame.pack();
    }

    public void initializeData(Student student) {
    }
}
