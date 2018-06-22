package view;

import lombok.Getter;
import lombok.Setter;
import domain.Student;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class StudentView {

    private JFrame frame;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JTextField nameText;
    private JTextField surnameText;
    private JButton saveButton;

    public StudentView(String title){
        frame = new JFrame(title);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(1024, 768);

    }

    public void initializeData(Student student) {
    }
}
