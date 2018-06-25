package presenter;

import exceptions.DatabaseConnectionException;
import exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import domain.Login;
import domain.User;
import model.DashboardModel;
import model.ErrorModel;
import view.DashboardView;
import view.ErrorView;
import view.LoginView;

import javax.swing.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginPresenter {

    private LoginView view;
    private Login model;

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
            DashboardView view = new DashboardView();
            view.setPresenter(new DashboardPresenter(view, new DashboardModel()));
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
