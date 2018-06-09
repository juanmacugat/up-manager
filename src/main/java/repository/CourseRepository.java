package repository;

import model.Course;

public class CourseRepository implements RelationalRepository<Course, String> {

    private static CourseRepository instance = new CourseRepository();

    public static CourseRepository getInstance(){
        return instance;
    }
}
