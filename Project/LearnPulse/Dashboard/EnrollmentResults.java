import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Assuming Student class is in the User package
import User.Student;

public class EnrollmentResults implements ActionListener {

    JFrame enrollmentResultsFrame;
    JPanel studentViewPanel, adminViewPanel;
    JTable enrollmentTable, resultsTable;
    JButton enrollButton, unenrollButton, manageResultsButton;

    Student student;
    Student[] allStudents;

    public EnrollmentResults(Student student, Student[] allStudents) {
        this.student = student;
        this.allStudents = allStudents;

        // Student View Panel
        studentViewPanel = new JPanel();
        enrollmentTable = new JTable();

        enrollButton = new JButton("Enroll");
        enrollButton.addActionListener(this);

        studentViewPanel.add(new JScrollPane(enrollmentTable));
        studentViewPanel.add(enrollButton);

        // Admin View Panel
        adminViewPanel = new JPanel();
        resultsTable = new JTable();
        unenrollButton = new JButton("Unenroll");
        manageResultsButton = new JButton("Manage Results");

        unenrollButton.addActionListener(this);
        manageResultsButton.addActionListener(this);

        adminViewPanel.add(new JScrollPane(resultsTable));
        adminViewPanel.add(unenrollButton);
        adminViewPanel.add(manageResultsButton);

        // Main Frame
        enrollmentResultsFrame = new JFrame();
        enrollmentResultsFrame.add(studentViewPanel);
        enrollmentResultsFrame.add(adminViewPanel);

        enrollmentResultsFrame.setLayout(new BoxLayout(enrollmentResultsFrame.getContentPane(), BoxLayout.Y_AXIS));
        enrollmentResultsFrame.setTitle("Enrollment/Results - Student Management System");
        enrollmentResultsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        enrollmentResultsFrame.setSize(600, 400);
        enrollmentResultsFrame.setLocationRelativeTo(null);
        enrollmentResultsFrame.setVisible(true);

        // Placeholder: Load initial data into tables
        // For simplicity, assuming some initial data
        initializeTables();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enrollButton) {
            // Placeholder: Implement code to enroll in courses
            JOptionPane.showMessageDialog(null, "Enroll in Course - Placeholder");
        } else if (e.getSource() == unenrollButton) {
            // Placeholder: Implement code to unenroll from courses
            JOptionPane.showMessageDialog(null, "Unenroll from Course - Placeholder");
        } else if (e.getSource() == manageResultsButton) {
            // Placeholder: Implement code to manage academic results
            JOptionPane.showMessageDialog(null, "Manage Results - Placeholder");
        }
    }

    private void initializeTables() {
        // Placeholder: Load initial data into enrollmentTable and resultsTable
        // For simplicity, assuming some initial data
        String[] enrollmentColumnNames = {"Course", "Status"};
        String[] resultsColumnNames = {"Course", "Grade"};

        Object[][] enrollmentData = {{"Course 1", "Enrolled"}, {"Course 2", "Not Enrolled"}};
        Object[][] resultsData = {{"Course 1", "A"}, {"Course 2", "B"}};

        DefaultTableModel enrollmentModel = new DefaultTableModel(enrollmentData, enrollmentColumnNames);
        DefaultTableModel resultsModel = new DefaultTableModel(resultsData, resultsColumnNames);

        enrollmentTable.setModel(enrollmentModel);
        resultsTable.setModel(resultsModel);
    }

    public static void main(String[] args) {
        Student dummyStudent = new Student("John Doe", "CS101", "john.doe@example.com", "Computer Science");
        Student[] dummyStudents = {dummyStudent};

        new EnrollmentResults(dummyStudent, dummyStudents);
    }
}
