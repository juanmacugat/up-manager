package courses;

import java.util.UUID;

public class Course {

    private String id = UUID.randomUUID().toString();
    private String name;
    private String teacher;
    private String major;
    private Integer pass_condition;

    public Course(){

    }

    public Course(final String name, final String teacher, final String major, final int condition){
        this.name = name;
        this.teacher = teacher;
        this.major = major;
        this.pass_condition = condition;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(final String major) {
        this.major = major;
    }

    public Integer getPass_condition() {
        return pass_condition;
    }

    public void setPass_condition(final Integer pass_condition) {
        this.pass_condition = pass_condition;
    }

    @Override
    public String toString() {
        return name;
    }
}
