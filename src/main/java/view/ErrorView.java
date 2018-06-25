package view;

import lombok.Getter;
import lombok.Setter;
import presenter.ErrorPresenter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class ErrorView {

    private ErrorPresenter presenter;
    private JFrame frame;
    private JLabel error;
    private JButton ok;

    public void initialize() {
        this.error = new JLabel(presenter.getMessage());
        this.ok = new JButton("CLOSE");
        this.ok.addActionListener(event -> {
            frame.setVisible(false);
            System.exit(0);
        });

        frame =  new JFrame("ERROR");
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(error);
        frame.getContentPane().add(ok);
        frame.pack();
        frame.setVisible(true);
    }
}
