package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginView extends JFrame {

    private final LoginPresenter presenter;
    private JPanel centerPanel, southPanel;
    private JTextField username;
    private JPasswordField password;
    private JButton loginButton, resetButton;

    public LoginView(final LoginPresenter presenter) {
        this.presenter = presenter;
        init();
    }

    private void init() {
        this.setTitle("Sistema de Gestion de Alumnos - UP");

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 2));
        centerPanel.add(new JLabel("usuario"));
        username = new JTextField();
        centerPanel.add(username);
        centerPanel.add(new JLabel("contrasena"));
        password = new JPasswordField();
        password.addKeyListener(new LoginListener());
        centerPanel.add(password);
        southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1, 2));
        loginButton = new JButton("ingresar");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.login(username.getText(), password.getPassword());
            }
        });
        southPanel.add(loginButton);
        resetButton = new JButton("cancelar");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username.setText("");
                password.setText("");
            }
        });
        southPanel.add(resetButton);

        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(450, 250, 375, 140);
        this.setResizable(false);
        this.setVisible(true);
    }

    private class LoginListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                login();
            }
        }
    }

    private void login() {
        presenter.login(username.getText(), password.getPassword());
    }


}
