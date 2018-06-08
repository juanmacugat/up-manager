package repository;

import model.User;

public class UserRepository implements RelationalRepository<User, String> {

    private static UserRepository instance = new UserRepository();

    public static UserRepository getInstance(){
        return instance;
    }
}
