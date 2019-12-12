package main;

import login.LoginPresenter;
import login.LoginView;

import javax.swing.*;

public class Application {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            LoginPresenter presenter = new LoginPresenter();
            LoginView view = new LoginView(presenter);
            presenter.setView(view);
        });
    }
}
