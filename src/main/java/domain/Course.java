package domain;

import java.util.UUID;

public class Course {

    private String id = UUID.randomUUID().toString();
    private String name;
    private Teacher teacher;



    public void setId(final String id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setTeacher(final Teacher teacher) {
        this.teacher = teacher;
    }

    public String getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
