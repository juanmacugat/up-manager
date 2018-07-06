package view;

import domain.Student;
import lombok.Getter;
import lombok.Setter;
import presenter.StudentsPresenter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static javax.swing.BoxLayout.X_AXIS;

@Getter
@Setter
public class StudentsView {

    private static final String[] headers = {"Id", "Name", "Surname", "Email", "Birthday", "Creation date"};

    private StudentsPresenter presenter;

    private JFrame frame;
    private JTable studentsTable;
    private JTextField txtName, txtSurname, txtEmail, txtBirthday;
    private JButton newButton;
    private JButton cancelButton;
    private JButton editButton;
    private DefaultTableModel tableModel;
    private DefaultTableModel studentsModel;

    public StudentsView(String title){
        initialize(title);
    }

    private void initialize(String title){

        frame = new JFrame(title);
        frame.getContentPane().setLayout(new GridLayout(0,1,3,3));
        frame.setLocationRelativeTo(null);
        frame.setPreferredSize(new Dimension(600,600));

        txtName = new JTextField();
        txtName.setPreferredSize(new Dimension(200,50));
        txtSurname = new JTextField();
        txtSurname.setPreferredSize(new Dimension(200,50));
        txtEmail = new JTextField();
        txtEmail.setPreferredSize(new Dimension(200,50));
        txtBirthday = new JTextField();
        txtBirthday.setPreferredSize(new Dimension(200,50));

        JPanel panelNombre = new JPanel();
        BoxLayout boxLayoutName = new BoxLayout(panelNombre, X_AXIS);
        panelNombre.add(new JLabel("NAME"));
        panelNombre.add(txtName);

        JPanel panelSurname= new JPanel();
        BoxLayout boxLayoutSurname = new BoxLayout(panelSurname, X_AXIS);
        panelSurname.add(new JLabel("SURNAME"));
        panelSurname.add(txtSurname);

        JPanel panelEmail = new JPanel();
        BoxLayout boxLayoutEmail = new BoxLayout(panelEmail, X_AXIS);
        panelEmail.add(new JLabel("EMAIL"));
        panelEmail.add(txtEmail);

        JPanel panelBirthday = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panelBirthday, X_AXIS);
        panelBirthday.add(new JLabel("BIRTHDAY"));
        panelBirthday.add(txtBirthday);

        newButton = new JButton("ADD");
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String surname = txtSurname.getText();
                String email = txtEmail.getText();
                Date birthday = null;
                try {
                    birthday = new SimpleDateFormat("yyyy-MM-dd").parse(txtBirthday.getText());
                } catch (ParseException e1) {
                    throw new RuntimeException();
                }

                Student student = new Student(name, surname, email, birthday, new Date());
                presenter.createStudent(student);
            }
        });
        editButton = new JButton("EDIT");
        editButton.addActionListener(new ActionListener() {
                                         @Override
                                         public void actionPerformed(ActionEvent e) {

                                             int selectedRow = studentsTable.getSelectedRow();
                                             String studentId = (String) studentsTable.getModel().getValueAt(selectedRow,0);
                                             Student student = presenter.findStudentById(studentId);

                                             String id = null, name = null, surname = null, email = null;
                                             Date birthday = null, creation = null;

                                             for (int i = 0; i < headers.length ; i++){

                                                 if(i == 0)
                                                     id = (String) studentsTable.getValueAt(selectedRow, getColumnByName(studentsTable,headers[i]));

                                                 if(i == 1) {
                                                     name = (String) studentsTable.getValueAt(selectedRow, getColumnByName(studentsTable, headers[i]));
                                                     student.setName(name);
                                                 }
                                                 if(i == 2) {
                                                     surname = (String) studentsTable.getValueAt(selectedRow, getColumnByName(studentsTable, headers[i]));
                                                     student.setSurname(surname);
                                                 }
                                                 if(i == 3) {
                                                     email = (String) studentsTable.getValueAt(selectedRow, getColumnByName(studentsTable, headers[i]));
                                                     student.setEmail(email);
                                                 }
                                                 if(i == 4) {
                                                     birthday = (Date) studentsTable.getValueAt(selectedRow, getColumnByName(studentsTable, headers[i]));
                                                     student.setBirthday(birthday);
                                                 }
                                                 if(i == 5) {
                                                     creation = (Date) studentsTable.getValueAt(selectedRow, getColumnByName(studentsTable, headers[i]));
                                                     student.setCreation_date(creation);
                                                 }
                                             }

                                             presenter.updateStudent(student);
                                         }
                                     }
        );

        cancelButton = new JButton("DELETE");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int selectedRow = studentsTable.getSelectedRow();
                String studentId = (String) studentsTable.getModel().getValueAt(selectedRow,0);
                Student student = presenter.findStudentById(studentId);
                presenter.deleteStudent(student);
            }
        });

        tableModel = new DefaultTableModel(){

            private static final long serialVersionUID = 1L;
            String[] headers = {"Id", "Name", "Surname", "Email", "Birthday", "Creation date"};

            @Override
            public int getColumnCount() {
                return headers.length;
            }

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }

            @Override
            public int getRowCount() {
                return 0;
            }

            @Override
            public String getColumnName(int index) {
                return headers[index];
            }

            public String[] getHeaders(){
                return headers;
            }
        };

        studentsTable = new JTable(tableModel);
        frame.getContentPane().add(new JScrollPane(studentsTable));
        frame.getContentPane().add(cancelButton);
        frame.getContentPane().add(editButton);
        frame.getContentPane().add(panelNombre);
        frame.getContentPane().add(panelSurname);
        frame.getContentPane().add(panelEmail);
        frame.getContentPane().add(panelBirthday);
        frame.getContentPane().add(newButton);
        frame.setVisible(true);
        frame.pack();
    }

    private int getColumnByName(JTable table, String header) {
        for (int i=0; i < table.getColumnCount(); i++) {
            if (table.getColumnName(i).equals(header)) return i;
        }
        return -1;
    }

    public void clearAll() {
        txtName.setText("");
        txtSurname.setText("");
        txtEmail.setText("");
        txtBirthday.setText("");
    }
}
