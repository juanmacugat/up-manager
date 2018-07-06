package view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import presenter.CoursesPresenter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.Arrays;

import static org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ;

@Getter
@Setter
@AllArgsConstructor
public class CoursesView{

    private static final String[] HEADERS = {"Id","Name","Teacher"};

    private CoursesPresenter presenter;
    private JFrame frame;
    private JButton newButton;
    private JButton cancelButton;
    private JButton editButton;
    private JTable courseTable;

    public CoursesView(){
        initialize();
    }

    private void initialize() {

        courseTable = new JTable();
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
        frame.getContentPane().add(courseTable);
        frame.getContentPane().add(newButton);
        frame.getContentPane().add(cancelButton);

        frame.pack();
        frame.setVisible(true);
    }


}
