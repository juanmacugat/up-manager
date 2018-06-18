package main;

import model.Login;
import presenter.LoginPresenter;
import view.LoginView;

import javax.swing.*;

public class Application {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->{
            LoginView view = new LoginView();
            view.setPresenter(new LoginPresenter(view, new Login()));
        });
    }
}
