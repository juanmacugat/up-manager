package domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Grade {

    private String id = UUID.randomUUID().toString();
    private Student student;
    private Course course;
    private Integer grade;
}
