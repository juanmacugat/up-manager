package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Course {

    private String id = UUID.randomUUID().toString();
    private String name;
    private List<Student> students = new ArrayList<Student>();
    private Teacher teacher;

}
