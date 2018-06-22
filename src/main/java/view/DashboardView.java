package view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import presenter.DashboardPresenter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

@Getter
@Setter
@AllArgsConstructor
public class DashboardView {

    private DashboardPresenter presenter;
    private JFrame frame;
    private JButton newButton;
    private JButton cancelButton;
    private JButton editButton;
    private JTable courseTables;
    private DefaultTableModel tableModel = new DefaultTableModel(5,5);

    public DashboardView(){
        initialize();
    }

    private void initialize() {

        courseTables = new JTable(tableModel);

        editButton = new JButton("EDIT");
        editButton.addActionListener(event -> {

        });
        newButton = new JButton("ADD");
        newButton.addActionListener(event->{

        });

        cancelButton = new JButton("CANCEL");
        cancelButton.addActionListener(event ->{
            frame.setVisible(false);
            System.exit(0);
        });

        frame =  new JFrame("DASHBOARD");
        frame.setLocationRelativeTo(null);

        frame.getContentPane().setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(0,1,3,3));
        frame.getContentPane().add(courseTables);
        frame.getContentPane().add(newButton);
        frame.getContentPane().add(cancelButton);

        frame.pack();
        frame.setVisible(true);
    }


}
