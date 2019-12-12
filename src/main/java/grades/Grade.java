package grades;

import java.util.UUID;

public class Grade {

    private String id;
    private String student_id;
    private String course_id;
    private Integer grade;

    public Grade() {
    }

    public Grade(final String student_id, final String course_id, final Integer grade) {
        this.id = UUID.randomUUID().toString();
        this.student_id = student_id;
        this.course_id = course_id;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(final String student_id) {
        this.student_id = student_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(final String course_id) {
        this.course_id = course_id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(final Integer grade) {
        this.grade = grade;
    }
}
