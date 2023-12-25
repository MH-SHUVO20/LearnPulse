import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Assuming Student class is in the User package
import User.Student;

public class SearchStudent implements ActionListener {

    JFrame searchStudentFrame;
    JPanel searchPanel, resultsPanel;
    JLabel nameLabel, programLabel;
    JTextField nameField, programField;
    JButton searchButton;
    JTable resultsTable;

    Student[] students;

    public SearchStudent(Student[] students) {
        this.students = students;

        // Search Panel
        searchPanel = new JPanel();
        nameLabel = new JLabel("Name:");
        programLabel = new JLabel("Program:");

        nameField = new JTextField(20);
        programField = new JTextField(20);

        searchButton = new JButton("Search");
        searchButton.addActionListener(this);

        searchPanel.add(nameLabel);
        searchPanel.add(nameField);
        searchPanel.add(programLabel);
        searchPanel.add(programField);
        searchPanel.add(searchButton);

        // Results Panel
        resultsPanel = new JPanel();
        resultsTable = new JTable();

        resultsPanel.add(new JScrollPane(resultsTable));

        // Main Frame
        searchStudentFrame = new JFrame();
        searchStudentFrame.add(searchPanel);
        searchStudentFrame.add(resultsPanel);

        searchStudentFrame.setLayout(new BoxLayout(searchStudentFrame.getContentPane(), BoxLayout.Y_AXIS));
        searchStudentFrame.setTitle("Search Student - Student Management System");
        searchStudentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        searchStudentFrame.setSize(600, 400);
        searchStudentFrame.setLocationRelativeTo(null);
        searchStudentFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            String name = nameField.getText();
            String program = programField.getText();

            // Placeholder: Implement code to search for students
            Student[] searchResults = searchStudents(name, program);

            // Display search results
            displaySearchResults(searchResults);
        }
    }

    private Student[] searchStudents(String name, String program) {
        // Placeholder: Implement code to search for students by name or program
        // Return an array of matching students
        // For now, returning a dummy array
        return students;
    }

    private void displaySearchResults(Student[] searchResults) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Name", "Program", "Email"});
        for (Student student : searchResults) {
            if (student != null) {
                model.addRow(new String[]{student.getName(), student.getProgram(), student.getEmail()});
            }
        }
        resultsTable.setModel(model);
    }

    public static void main(String[] args) {
        new SearchStudent(new Student[0]); // Pass your array of students
    }
}
