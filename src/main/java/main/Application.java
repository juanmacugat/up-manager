package main;

import login.LoginView;
import login.LoginPresenter;

import javax.swing.*;

public class Application {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->{
            LoginPresenter presenter = new LoginPresenter();
            LoginView view = new LoginView(presenter);
            presenter.setView(view);

//            DashboardView dashboardView = new DashboardView();
        });
    }
}
