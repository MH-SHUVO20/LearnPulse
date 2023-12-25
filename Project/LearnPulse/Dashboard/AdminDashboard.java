import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboard implements ActionListener {

    JFrame adminFrame;
    JPanel studentManagementPanel, courseManagementPanel, systemManagementPanel;
    JButton viewStudentsButton, addStudentButton, editStudentButton, deleteStudentButton;
    JButton createCourseButton, editCourseButton, deleteCourseButton, assignInstructorButton;
    JButton systemSettingsButton;

    public AdminDashboard() {
        adminFrame = new JFrame();
        
        // Student Management Panel
        studentManagementPanel = new JPanel();
        viewStudentsButton = new JButton("View Students");
        addStudentButton = new JButton("Add Student");
        editStudentButton = new JButton("Edit Student");
        deleteStudentButton = new JButton("Delete Student");

        // Add action listeners to buttons
        viewStudentsButton.addActionListener(this);
        addStudentButton.addActionListener(this);
        editStudentButton.addActionListener(this);
        deleteStudentButton.addActionListener(this);

        studentManagementPanel.add(viewStudentsButton);
        studentManagementPanel.add(addStudentButton);
        studentManagementPanel.add(editStudentButton);
        studentManagementPanel.add(deleteStudentButton);

        // Course Management Panel
        courseManagementPanel = new JPanel();
        createCourseButton = new JButton("Create Course");
        editCourseButton = new JButton("Edit Course");
        deleteCourseButton = new JButton("Delete Course");
        assignInstructorButton = new JButton("Assign Instructor");

        // Add action listeners to buttons
        createCourseButton.addActionListener(this);
        editCourseButton.addActionListener(this);
        deleteCourseButton.addActionListener(this);
        assignInstructorButton.addActionListener(this);

        courseManagementPanel.add(createCourseButton);
        courseManagementPanel.add(editCourseButton);
        courseManagementPanel.add(deleteCourseButton);
        courseManagementPanel.add(assignInstructorButton);

        // System Management Panel
        systemManagementPanel = new JPanel();
        systemSettingsButton = new JButton("System Settings");

        // Add action listener to button
        systemSettingsButton.addActionListener(this);

        systemManagementPanel.add(systemSettingsButton);

        // Add panels to the frame
        adminFrame.add(studentManagementPanel);
        adminFrame.add(courseManagementPanel);
        adminFrame.add(systemManagementPanel);

        // Set layout and properties of the frame
        adminFrame.setLayout(new BoxLayout(adminFrame.getContentPane(), BoxLayout.Y_AXIS));
        adminFrame.setTitle("Admin Dashboard - Student Management System");
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setSize(400, 300);
        adminFrame.setLocationRelativeTo(null);
        adminFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        if (e.getSource() == viewStudentsButton) {
            // Placeholder: Implement code to view students
            JOptionPane.showMessageDialog(null, "View Students - Placeholder");
        } else if (e.getSource() == addStudentButton) {
            // Placeholder: Implement code to add a student
            JOptionPane.showMessageDialog(null, "Add Student - Placeholder");
        } else if (e.getSource() == editStudentButton) {
            // Placeholder: Implement code to edit a student
            JOptionPane.showMessageDialog(null, "Edit Student - Placeholder");
        } else if (e.getSource() == deleteStudentButton) {
            // Placeholder: Implement code to delete a student
            JOptionPane.showMessageDialog(null, "Delete Student - Placeholder");
        } else if (e.getSource() == createCourseButton) {
            // Placeholder: Implement code to create a course
            JOptionPane.showMessageDialog(null, "Create Course - Placeholder");
        } else if (e.getSource() == editCourseButton) {
            // Placeholder: Implement code to edit a course
            JOptionPane.showMessageDialog(null, "Edit Course - Placeholder");
        } else if (e.getSource() == deleteCourseButton) {
            // Placeholder: Implement code to delete a course
            JOptionPane.showMessageDialog(null, "Delete Course - Placeholder");
        } else if (e.getSource() == assignInstructorButton) {
            // Placeholder: Implement code to assign an instructor to a course
            JOptionPane.showMessageDialog(null, "Assign Instructor - Placeholder");
        } else if (e.getSource() == systemSettingsButton) {
            // Placeholder: Implement code to access system settings
            JOptionPane.showMessageDialog(null, "System Settings - Placeholder");
        }
    }

    public static void main(String[] args) {
        new AdminDashboard();
    }
}
