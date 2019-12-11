package error;

import javax.swing.*;
import java.awt.*;

public class ErrorView {

    private ErrorPresenter presenter;
    private JFrame frame;
    private JLabel error;
    private JButton ok;

    public void initialize() {
        this.error = new JLabel(presenter.getMessage());
        this.ok = new JButton("close");
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

    public void setPresenter(final ErrorPresenter errorPresenter) {
        this.presenter = errorPresenter;
    }
}
