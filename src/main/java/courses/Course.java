package courses;

import java.util.UUID;

public class Course {

    private String id = UUID.randomUUID().toString();
    private String name;
    private String teacher;

    public Course(){

    }

    public Course(final String name){
        this.name = name;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setTeacher(final String teacher) {
        this.teacher = teacher;
    }

    public String getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public String getTeacher() {
        return teacher;
    }

    @Override
    public String toString() {
        return name;
    }
}
