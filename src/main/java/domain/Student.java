package domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Student {

    private String id = UUID.randomUUID().toString();
    private String name;
    private String surname;
    private String email;
    private Date birthday;
    private Date creationDate;

    public Student(String name, String surname, String email, Date birthday, Date creationDate){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthday = birthday;
        this.creationDate = creationDate;
    }
}
