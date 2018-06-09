package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Teacher {

    private String id = UUID.randomUUID().toString();
    private String name;
    private String surname;

}
