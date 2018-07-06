package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainView {

    //Where the GUI is created:
    JMenuBar menuBar;
    JMenu options;
    JMenuItem itemStudents, itemCourses, itemTeachers, itemExit;
    JFrame frame;

    public MainView(){
        initialize();
    }

    public void initialize(){

        menuBar = new JMenuBar();
        options = new JMenu("Options");
        options.setMnemonic(KeyEvent.VK_A);
        menuBar.add(options);

        itemStudents= new JMenuItem("Students",
                KeyEvent.VK_T);
        itemStudents.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        itemStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() ->{
                    StudentsView view  = new StudentsView("Students");
                });
            }
        });
        options.add(itemStudents);

        options.addSeparator();

        itemCourses = new JMenuItem("Courses",
                KeyEvent.VK_T);
        itemCourses.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        options.add(itemCourses);

        options.addSeparator();

        itemTeachers = new JMenuItem("Teachers",
                KeyEvent.VK_T);
        itemTeachers.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        options.add(itemTeachers);

        options.addSeparator();

        itemExit = new JMenuItem("Exit",
                KeyEvent.VK_T);
        itemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        options.add(itemExit);

        frame =  new JFrame("DASHBOARD");
        frame.setLocationRelativeTo(null);
        frame.setPreferredSize(new Dimension(600,600));

        frame.getContentPane().setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(0,1,3,3));

        frame.pack();
        frame.setVisible(true);

        frame.setJMenuBar(menuBar);
    }
}