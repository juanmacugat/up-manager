package presenter;

import domain.Login;
import domain.User;
import exceptions.DatabaseConnectionException;
import exceptions.UserNotFoundException;
import model.ErrorModel;
import view.CoursesView;
import view.ErrorView;
import view.LoginView;
import view.MainView;

import javax.swing.*;

public class LoginPresenter {

    private LoginView view;
    private Login model;

    public LoginPresenter(final LoginView view, final Login login) {
        this.view = view;
        this.model = login;
    }

    public void login(String username, String password){

        try {
            User session = model.authenticate(username, password);
            success(session);
        } catch (DatabaseConnectionException | UserNotFoundException e) {
            fail(e.getMessage());
        }
    }

    private void success(User session) {
        view.getFrame().setVisible(false);
        SwingUtilities.invokeLater(() ->{
            MainView view = new MainView();
//            CoursesView view = new CoursesView();
//            view.setPresenter(new CoursesPresenter(view));
        });
    }

    private void fail(String message) {
        view.getFrame().setVisible(false);
        SwingUtilities.invokeLater(() ->{
            ErrorView view = new ErrorView();
            view.setPresenter(new ErrorPresenter(view, new ErrorModel(message)));
            view.initialize();
        });
    }
}
