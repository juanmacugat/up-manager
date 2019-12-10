package domain;

import exceptions.UserNotFoundException;
import org.mindrot.jbcrypt.BCrypt;
import repository.UserRepository;

public class Login {

    private String username;
    private String password;

    public User authenticate(String username, String password) throws UserNotFoundException {
        User user = UserRepository.getInstance().findByUsername(username);
        if(user != null)
            if(BCrypt.checkpw(password, user.getPassword()))
                return user;

        throw new UserNotFoundException("We couldnt found username: " + username);
    }
}
