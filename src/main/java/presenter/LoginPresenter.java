package presenter;

import exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.DashboardModel;
import model.Login;
import model.User;
import view.DashboardView;
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
        } catch (UserNotFoundException e) {
            fail();
        }

    }

    private void success(User session) {
        view.getFrame().setVisible(false);
        SwingUtilities.invokeLater(() ->{
            DashboardView view = new DashboardView();
            view.setPresenter(new DashboardPresenter(view, new DashboardModel()));
        });
    }

    private void fail() {
    }

    private void loginUnsuccessful() {

    }

    private void enterDashboard() {
    }
}
