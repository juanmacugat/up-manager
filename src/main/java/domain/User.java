package domain;

import java.util.UUID;

public class User {

    private String id = UUID.randomUUID().toString();
    private String username;
    private String password;

    public User(){

    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }
}
