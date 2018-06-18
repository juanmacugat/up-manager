package main;

import model.Login;
import model.User;
import org.mindrot.jbcrypt.BCrypt;
import presenter.LoginPresenter;
import repository.UserRepository;
import view.LoginView;

import javax.swing.*;

public class Application {

    public static void main(String[] args) {

        User user = new User("user", BCrypt.hashpw("test", BCrypt.gensalt()));
        UserRepository.getInstance().save(user);

        SwingUtilities.invokeLater(() ->{
            LoginView view = new LoginView();
            view.setPresenter(new LoginPresenter(view, new Login()));
        });
    }
}
