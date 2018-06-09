package main;

import presenter.StudentPresenter;
import view.StudentView;

public class Application {

    public static void main(String[] args) {

        StudentView studentView = new StudentView("Informacion del alumno");
        StudentPresenter studentPresenter = new StudentPresenter(studentView);

    }
}
