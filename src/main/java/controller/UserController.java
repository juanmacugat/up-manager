package controller;

import model.User;
import repository.UserRepository;

public class UserController {

    private UserRepository userRepository = UserRepository.getInstance();

    public void createUser(User user){
        userRepository.save(user);
    }
}
