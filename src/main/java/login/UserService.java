package login;

import exceptions.UserNotFoundException;
import org.mindrot.jbcrypt.BCrypt;

public class UserService {

    private static UserService instance = new UserService();

    public static UserService getInstance(){
        return instance;
    }

    private UserService(){

    }

    public User authenticate(String username, char[] password) throws UserNotFoundException {
        User user = UserRepository.getInstance().findByUsername(username);
        if(user != null)
            if(BCrypt.checkpw(String.valueOf(password), user.getPassword()))
                return user;

        throw new UserNotFoundException("We couldnt found username: " + username);
    }
}
