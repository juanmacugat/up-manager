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
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton loginButton, resetButton;

    public LoginView(final LoginPresenter presenter) {
        this.presenter = presenter;
        init();
    }

    private void init() {
        this.setTitle("Sistema de Gestion de Alumnos - UP");

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 2));

        JLabel lblUsername = new JLabel("usuario");
        lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(lblUsername);

        txtUsername = new JTextField();
        centerPanel.add(txtUsername);

        JLabel lblPassword = new JLabel("contrasena");
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.addKeyListener(new LoginListener());
        centerPanel.add(txtPassword);

        southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1, 2));

        loginButton = new JButton("ingresar");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.login(txtUsername.getText(), txtPassword.getPassword());
            }
        });
        southPanel.add(loginButton);
        resetButton = new JButton("cancelar");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtUsername.setText("");
                txtPassword.setText("");
            }
        });
        southPanel.add(resetButton);

        getContentPane().add(centerPanel, BorderLayout.CENTER);
        getContentPane().add(southPanel, BorderLayout.SOUTH);

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
        presenter.login(txtUsername.getText(), txtPassword.getPassword());
    }


}
