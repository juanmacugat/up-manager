package main;

import controller.StudentController;
import view.StudentView;

public class Application {

    public static void main(String[] args) {

        StudentView studentView = new StudentView("Informacion del alumno");
        StudentController studentController = new StudentController(studentView);

    }
}
