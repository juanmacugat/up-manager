package service;

import domain.Course;
import repository.CourseRepository;

import java.util.List;

public class CourseServiceImpl implements CourseService {


    @Override
    public List<Course> findAllCourses() {
        return CourseRepository.getInstance().findAll();
    }

    @Override
    public void addCourse(Course course) {

    }

    @Override
    public void deleteCourse(Course course) {

    }

    @Override
    public void editCourse(Course course) {

    }
}
