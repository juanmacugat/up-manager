package dashboard;

import courses.CoursesPresenter;
import courses.CoursesView;
import enrollments.EnrollmentPresenter;
import enrollments.EnrollmentView;
import grades.GradesPresenter;
import grades.GradesView;
import students.StudentsView;
import students.StudentsPresenter;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DashboardView extends JFrame {

    public static final String TITLE = "Universidad de Palermo - Sistema de Gestion de Alumnos";

    public DashboardView(){

        CoursesView coursesView = new CoursesView();
        CoursesPresenter coursesPresenter = new CoursesPresenter(coursesView);
        coursesView.setPresenter(coursesPresenter);

        GradesView gradesView = new GradesView();
        GradesPresenter gradesPresenter = new GradesPresenter(gradesView);
        gradesView.setPresenter(gradesPresenter);

        StudentsView studentsView1 = new StudentsView();
        StudentsPresenter studentsPresenter1 = new StudentsPresenter(studentsView1);
        studentsView1.setPresenter(studentsPresenter1);

        EnrollmentView enrollmentView = new EnrollmentView();
        EnrollmentPresenter enrollmentPresenter = new EnrollmentPresenter(enrollmentView);
        enrollmentView.setPresenter(enrollmentPresenter);
        enrollmentView.initialize();

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Materias", coursesView);
        tabs.addTab("Alumnos", studentsView1);
        tabs.addTab("Inscripciones", enrollmentView);
        tabs.addTab("Notas", gradesView);

        tabs.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(final ChangeEvent e) {
                enrollmentView.update();
            }
        });

        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().add(tabs);

        pack();

    }

}
