import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import Dashboard.*;
import User.*;

public class StudentDashboard implements ActionListener {

    JFrame studentDashboardFrame;
    JPanel profilePanel, searchPanel, enrollmentPanel;
    JLabel nameLabel, emailLabel, phoneLabel, programLabel;
    JTextField searchField;
    JButton updateProfileButton, searchButton, enrollButton;
    JTable searchResultsTable, enrollmentTable;

    Student[] students;
    int loggedInStudentIndex; // Index of the logged-in student

    public StudentDashboard(Student[] students, int loggedInStudentIndex) {
        this.students = students;
        this.loggedInStudentIndex = loggedInStudentIndex;

        studentDashboardFrame = new JFrame();

        // Profile Panel
        profilePanel = new JPanel();
        profilePanel.setLayout(new GridLayout(4, 2));
        profilePanel.setBounds(100, 50, 800, 200);

        nameLabel = new JLabel("Name: ");
        emailLabel = new JLabel("Email: ");
        phoneLabel = new JLabel("Phone Number: ");
        programLabel = new JLabel("Program: ");

        updateProfileButton = new JButton("Update Profile");
        updateProfileButton.addActionListener(this);

        profilePanel.add(nameLabel);
        profilePanel.add(new JLabel(""));
        profilePanel.add(emailLabel);
        profilePanel.add(new JLabel(""));
        profilePanel.add(phoneLabel);
        profilePanel.add(new JLabel(""));
        profilePanel.add(programLabel);
        profilePanel.add(new JLabel(""));
        profilePanel.add(updateProfileButton);

        // Search Panel
        searchPanel = new JPanel();
        searchPanel.setLayout(new BorderLayout());
        searchPanel.setBounds(100, 300, 800, 200);

        searchField = new JTextField();
        searchButton = new JButton("Search");
        searchButton.addActionListener(this);

        searchResultsTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(searchResultsTable);

        searchPanel.add(searchField, BorderLayout.NORTH);
        searchPanel.add(searchButton, BorderLayout.NORTH);
        searchPanel.add(scrollPane, BorderLayout.CENTER);

        // Enrollment Panel
        enrollmentPanel = new JPanel();
        enrollmentPanel.setLayout(new BorderLayout());
        enrollmentPanel.setBounds(100, 550, 800, 200);

        enrollButton = new JButton("Enroll in Course");
        enrollButton.addActionListener(this);

        enrollmentTable = new JTable();
        JScrollPane enrollmentScrollPane = new JScrollPane(enrollmentTable);

        enrollmentPanel.add(enrollButton, BorderLayout.NORTH);
        enrollmentPanel.add(enrollmentScrollPane, BorderLayout.CENTER);

        // Initialize profile information
        displayProfile(students[loggedInStudentIndex]);

        studentDashboardFrame.add(profilePanel);
        studentDashboardFrame.add(searchPanel);
        studentDashboardFrame.add(enrollmentPanel);
        studentDashboardFrame.setLayout(null);
        studentDashboardFrame.setTitle("Student Dashboard - Student Management System");
        studentDashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentDashboardFrame.setSize(1000, 800);
        studentDashboardFrame.setLocationRelativeTo(null);
        studentDashboardFrame.setVisible(true);
    }

    public void displayProfile(Student student) {
        nameLabel.setText("Name: " + student.getName());
        emailLabel.setText("Email: " + student.getEmail());
        phoneLabel.setText("Phone Number: " + student.getPhoneNumber());
        programLabel.setText("Program: " + student.getProgram());
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateProfileButton) {
            // Open the profile update dialog
            new ProfileUpdateDialog(students[loggedInStudentIndex], this);
        } else if (e.getSource() == searchButton) {
            // Implement code to search for students
            String searchQuery = searchField.getText();
            Student[] searchResults = searchStudents(searchQuery);
            displaySearchResults(searchResults);
        } else if (e.getSource() == enrollButton) {
            // Implement code to enroll in courses
            enrollInCourse();
        }
    }

    private Student[] searchStudents(String query) {
        if (query == null || query.trim().isEmpty()) {
            return new Student[0];
        }

        String lowerCaseQuery = query.toLowerCase();
        java.util.List<Student> matchingStudents = new java.util.ArrayList<>();

        for (Student student : students) {
            if (student != null) {
                String studentName = student.getName().toLowerCase();
                String program = student.getProgram().toLowerCase();

                if (studentName.contains(lowerCaseQuery) || program.contains(lowerCaseQuery)) {
                    matchingStudents.add(student);
                }
            }
        }

        return matchingStudents.toArray(new Student[0]);
    }

    private void displaySearchResults(Student[] searchResults) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Name", "Program", "Email"});
        for (Student student : searchResults) {
            if (student != null) {
                model.addRow(new String[]{student.getName(), student.getProgram(), student.getEmail()});
            }
        }
        searchResultsTable.setModel(model);
    }

    private void enrollInCourse() {
        String[] courses = {"Course 1", "Course 2", "Course 3"}; // Example list of available courses

        String selectedCourse = (String) JOptionPane.showInputDialog(null,
                "Select a course to enroll in:",
                "Course Enrollment",
                JOptionPane.QUESTION_MESSAGE,
                null,
                courses,
                courses[0]);

        if (selectedCourse != null) {
            // Placeholder: Implement code to enroll the student in the selected course
            // You may update the enrollmentTable with the new enrollment information

            // Display a confirmation message
            JOptionPane.showMessageDialog(null, "Enrolled in " + selectedCourse + " successfully!");
        }
    }

    public void updateProfileInformation(String newName, String newEmail, String newPhone, String newProgram) {
        students[loggedInStudentIndex].setName(newName);
        students[loggedInStudentIndex].setEmail(newEmail);
        students[loggedInStudentIndex].setPhoneNumber(newPhone);
        students[loggedInStudentIndex].setProgram(newProgram);

        displayProfile(students[loggedInStudentIndex]);
    }

    public static void main(String[] args) {
        // Example usage
        Student[] students = new Student[1];
        students[0] = new Student("John Doe", "john.doe@example.com", "1234567890", "Computer Science");
        new StudentDashboard(students, 0);
    }
}
