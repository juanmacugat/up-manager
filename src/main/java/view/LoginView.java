package view;

import presenter.LoginPresenter;

import javax.swing.*;
import java.awt.*;

public class LoginView {

    private LoginPresenter presenter;
    private JFrame frame;
    private JLabel insertUsername;
    private JLabel insertPassword;
    private JTextField username;
    private JPasswordField password;
    private JButton loginButton;
    private JButton cancelButton;

    public JFrame getFrame(){
        return frame;
    }

    public LoginView(){
        initialize();
    }

    private void initialize() {
        loginButton = new JButton("LOGIN");
        loginButton.addActionListener(event->{
            presenter.login(username.getText(), password.getText());
        });

        cancelButton = new JButton("CANCEL");
        cancelButton.addActionListener(event ->{
            frame.setVisible(false);
            System.exit(0);
        });

        insertUsername = new JLabel("Username: ");
        insertPassword = new JLabel("Password: ");

        username = new JTextField();
        password = new JPasswordField();

        frame =  new JFrame("UP MANAGER");
        frame.setLocationRelativeTo(null);

        frame.getContentPane().setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.getContentPane().setLayout(new GridLayout(0,2,2,2));
        frame.getContentPane().add(insertUsername);
        frame.getContentPane().add(username);
        frame.getContentPane().add(insertPassword);
        frame.getContentPane().add(password);
        frame.getContentPane().add(loginButton);
        frame.getContentPane().add(cancelButton);

        frame.pack();
        frame.setVisible(true);
    }

    public void setPresenter(final LoginPresenter loginPresenter) {
        this.presenter = loginPresenter;
    }
}
