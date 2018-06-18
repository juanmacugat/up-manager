package view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import presenter.DashboardPresenter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
@AllArgsConstructor
public class DashboardView {

    private DashboardPresenter presenter;
    private JFrame frame;
    private JButton saveButton;
    private JButton cancelButton;

    public DashboardView(){
        initialize();
    }

    private void initialize() {
        saveButton = new JButton("SAVE");
        saveButton.addActionListener(event->{

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
        frame.getContentPane().setLayout(new GridLayout(0,2,2,2));
        frame.getContentPane().add(saveButton);
        frame.getContentPane().add(cancelButton);

        frame.pack();
        frame.setVisible(true);
    }


}
