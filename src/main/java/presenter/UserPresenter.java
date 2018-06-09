package presenter;

import model.User;
import repository.UserRepository;

public class UserPresenter {

    private UserRepository userRepository = UserRepository.getInstance();

    public void createUser(User user){
        userRepository.save(user);
    }
}
