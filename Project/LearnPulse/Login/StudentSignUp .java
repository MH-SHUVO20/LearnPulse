import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentSignUp implements ActionListener {

    private Student[] students = new Student[100];

    private JFrame stuSignupFrame;
    private JPanel studentSignUp;
    private JPanel signupComplete;
    private JLabel l1, l2;
    private JTextField tf1, tf2, tf3;
    private JPasswordField sp1, ssp1;
    private JButton signUp, returnToLogin, returnToSignup;

    public StudentSignUp() {
        stuSignupFrame = new JFrame();

        studentSignUp = new JPanel();

        l1 = new JLabel("Signup as Student");
        // ... (other label configurations)

        tf1 = new JTextField("Name");
        // ... (other text field configurations)

        sp1 = new JPasswordField("Student Password", 7);
        // ... (other password field configurations)

        signUp = new JButton("Sign Up");
        // ... (other button configurations)

        // ... (setting up other components)

        studentSignUp.add(l1);
        studentSignUp.add(tf1);
        // ... (add other components)
        studentSignUp.setLayout(null);
        studentSignUp.setBounds(0, 0, 1000, 700);
        studentSignUp.setBackground(Color.GREEN);
        studentSignUp.setVisible(true);

        signupComplete = new JPanel();

        l2 = new JLabel("Account has been successfully created!");
        // ... (other label configurations)

        returnToLogin = new JButton("Return to Login");
        // ... (other button configurations)

        returnToSignup = new JButton("Return to Signup");
        // ... (other button configurations)

        // ... (setting up other components)

        signupComplete.add(l2);
        signupComplete.add(returnToLogin);
        signupComplete.add(returnToSignup);
        signupComplete.setLayout(null);
        signupComplete.setBounds(0, 0, 1000, 700);
        signupComplete.setBackground(Color.GREEN);
        signupComplete.setVisible(false);

        stuSignupFrame.add(studentSignUp);
        stuSignupFrame.add(signupComplete);
        stuSignupFrame.setLayout(null);
        stuSignupFrame.setTitle("Student Signup - Student Management System");
        stuSignupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stuSignupFrame.setSize(1000, 700);
        stuSignupFrame.setLocationRelativeTo(null);
        stuSignupFrame.setVisible(true);
    }

    public void addStudent(Student s) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = s;
                break;
            }
        }
    }

    public Student[] getStudents() {
        return students;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUp) {
            String name = tf1.getText();
            // ... (get other input values)

            if (name != null && !name.isEmpty()) {
                Student s = new Student(name);
                addStudent(s);
                studentSignUp.setVisible(false);
                signupComplete.setVisible(true);
            }
        }

        if (e.getSource() == returnToLogin) {
            stuSignupFrame.setVisible(false);
            new Login(getStudents());
        }

        if (e.getSource() == returnToSignup) {
            signupComplete.setVisible(false);
            studentSignUp.setVisible(true);
        }
    }
}
