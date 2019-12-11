package login;

import error.ErrorPresenter;
import exceptions.DatabaseConnectionException;
import exceptions.UserNotFoundException;
import error.ErrorModel;
import dashboard.DashboardView;
import error.ErrorView;

import javax.swing.*;

public class LoginPresenter {

    private LoginView view;
    private UserService service = UserService.getInstance();

    public LoginPresenter() {
    }

    public void setView(final LoginView view){
        this.view = view;
    }

    public void login(String username, char[] password){

        try {
            User session = service.authenticate(username, password);
            success(session);
        } catch (DatabaseConnectionException | UserNotFoundException e) {
            fail(e.getMessage());
        }
    }

    private void success(User session) {
        view.setVisible(false);
        SwingUtilities.invokeLater(() ->{
            DashboardView view = new DashboardView();
        });
    }

    private void fail(String message) {
        SwingUtilities.invokeLater(() ->{
            JOptionPane.showMessageDialog(null,
                    message,
                    "Error", JOptionPane.ERROR_MESSAGE);
        });
    }
}
