package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id = UUID.randomUUID().toString();
    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

}
