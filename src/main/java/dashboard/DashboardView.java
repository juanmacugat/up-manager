package dashboard;

import courses.CoursesPresenter;
import courses.CoursesView;
import enrollments.EnrollmentPresenter;
import enrollments.EnrollmentView;
import grades.GradesPresenter;
import grades.GradesView;
import students.NewStudentsView;
import students.StudentsPresenter;

import javax.swing.*;

public class DashboardView extends JFrame {

    public static final String TITLE = "Universidad de Palermo - Sistema de Gestion de Alumnos";

    public DashboardView(){

        CoursesView coursesView = new CoursesView();
        CoursesPresenter coursesPresenter = new CoursesPresenter(coursesView);
        coursesView.setPresenter(coursesPresenter);

        GradesView gradesView = new GradesView();
        GradesPresenter gradesPresenter = new GradesPresenter(gradesView);
        gradesView.setPresenter(gradesPresenter);

        NewStudentsView studentsView1 = new NewStudentsView();
        StudentsPresenter studentsPresenter1 = new StudentsPresenter(studentsView1);
        studentsView1.setPresenter(studentsPresenter1);

        EnrollmentView enrollmentView = new EnrollmentView();
        EnrollmentPresenter enrollmentPresenter = new EnrollmentPresenter(enrollmentView);
        enrollmentView.setPresenter(enrollmentPresenter);
        enrollmentView.initialize();

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Materias", coursesView);
        tabs.addTab("Alumnos", studentsView1);
        tabs.addTab("Notas", gradesView);
        tabs.add("Inscripciones", enrollmentView);

        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().add(tabs);

        pack();

    }

}
