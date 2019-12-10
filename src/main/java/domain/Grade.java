package domain;

import java.util.UUID;

public class Grade {

    private String id = UUID.randomUUID().toString();
    private Student student;
    private Course course;
    private Integer grade;

    public void setId(final String id) {
        this.id = id;
    }

    public void setStudent(final Student student) {
        this.student = student;
    }

    public void setGrade(final int grade) {
        this.grade = grade;
    }

    public void setCourse(final Course course) {
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public long getGrade() {
        return grade;
    }
}
