package dashboard;

import courses.CoursesView;
import grades.GradesPresenter;
import grades.GradesView;
import students.NewStudentsView;
import students.StudentsView;
import courses.CoursesPresenter;
import students.StudentsPresenter;

import javax.swing.*;

public class DashboardView extends JFrame {

    public static final String TITLE = "Universidad de Palermo - Sistema de Gestion de Alumnos";

    public DashboardView(){

//        StudentsView studentsView = new StudentsView();
//        StudentsPresenter studentsPresenter = new StudentsPresenter(studentsView);
//        studentsView.setPresenter(studentsPresenter);

        CoursesView coursesView = new CoursesView();
        CoursesPresenter coursesPresenter = new CoursesPresenter(coursesView);
        coursesView.setPresenter(coursesPresenter);

        GradesView gradesView = new GradesView();
        GradesPresenter gradesPresenter = new GradesPresenter(gradesView);
        gradesView.setPresenter(gradesPresenter);

        NewStudentsView studentsView1 = new NewStudentsView();
        StudentsPresenter studentsPresenter1 = new StudentsPresenter(studentsView1);
        studentsView1.setPresenter(studentsPresenter1);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Materia", coursesView);
        tabs.addTab("Alumnos", studentsView1);
        tabs.addTab("Notas", gradesView);

        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().add(tabs);

        pack();

    }

}
