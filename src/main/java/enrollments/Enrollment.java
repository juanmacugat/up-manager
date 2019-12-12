package enrollments;

import java.util.UUID;

public class Enrollment {

    private String id;
    private String course_id;
    private String student_id;

    public Enrollment(){

    }

    public Enrollment(final String course_id, final String student_id) {
        this.id = UUID.randomUUID().toString();
        this.course_id = course_id;
        this.student_id = student_id;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(final String course_id) {
        this.course_id = course_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(final String student_id) {
        this.student_id = student_id;
    }

}
