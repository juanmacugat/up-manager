package repository;

import domain.User;

public class UserRepository implements RelationalRepository<User, String> {

    private static UserRepository instance = new UserRepository();

    public static UserRepository getInstance(){
        return instance;
    }


    public User findByUsername(String username) {
        return this.findByField("username", username);
    }
}
