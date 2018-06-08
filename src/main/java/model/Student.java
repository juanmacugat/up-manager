package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Student {

    private String id = UUID.randomUUID().toString();
    private String name;
    private String surname;
    private String studentId;

    public Student(String name, String surname, String studentId){
        this.name = name;
        this.surname = surname;
        this.studentId = studentId;
    }
}
