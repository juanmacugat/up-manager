package domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Course {

    private String id = UUID.randomUUID().toString();
    private String name;
    private Teacher teacher;

}