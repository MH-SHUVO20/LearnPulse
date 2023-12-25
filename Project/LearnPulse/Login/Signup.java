import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import Dashboard.*;
import Login.*;
import User.*;

public class Signup implements ActionListener {

    Student[] students = new Student[100];

    JFrame studentSignupFrame;
    JPanel studentSignUp;
    JPanel signupComplete;
    JLabel l1, l2;
    JTextField tf1, tf2, tf3, tf4;
    JPasswordField cp1, ccp1;
    JComboBox<String> bloodGroupComboBox, genderComboBox;
    JButton signUp, returnToLogin, returnToSignup;

    Signup(Student[] existingStudents) {
        this.students = existingStudents;

        studentSignupFrame = new JFrame();

        studentSignUp = new JPanel();

        l1 = new JLabel("Signup as Student");
        l1.setBounds(300, 50, 400, 80);
        Font bigFont = l1.getFont().deriveFont(Font.PLAIN, 40f);
        l1.setFont(bigFont);

        tf1 = new JTextField("Name");
        tf1.setBounds(300, 150, 150, 30);
        tf1.setFont(bigFont);

        tf2 = new JTextField("Roll Number");
        tf2.setBounds(300, 200, 150, 30);
        tf2.setFont(bigFont);

        tf3 = new JTextField("Email");
        tf3.setBounds(300, 250, 150, 30);
        tf3.setFont(bigFont);

        tf4 = new JTextField("Contact Number");
        tf4.setBounds(300, 300, 150, 30);
        tf4.setFont(bigFont);

        bloodGroupComboBox = new JComboBox<>(new String[]{"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"});
        bloodGroupComboBox.setBounds(750, 150, 150, 30);
        bloodGroupComboBox.setFont(bigFont);

        genderComboBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        genderComboBox.setBounds(750, 200, 150, 30);
        genderComboBox.setFont(bigFont);

        cp1 = new JPasswordField("Student Password", 7);
        cp1.setBounds(750, 250, 150, 30);
        cp1.setFont(bigFont);

        ccp1 = new JPasswordField("Confirm Password", 7);
        ccp1.setBounds(750, 300, 150, 30);
        ccp1.setFont(bigFont);

        signUp = new JButton();
        signUp.setBounds(300, 350, 70, 30);
        signUp.addActionListener(this);
        signUp.setOpaque(false);
        signUp.setContentAreaFilled(false);
        signUp.setBorderPainted(true);
        signUp.setForeground(Color.BLACK);

        studentSignUp.add(l1);
        studentSignUp.add(tf1);
        studentSignUp.add(tf2);
        studentSignUp.add(tf3);
        studentSignUp.add(tf4);
        studentSignUp.add(bloodGroupComboBox);
        studentSignUp.add(genderComboBox);
        studentSignUp.add(cp1);
        studentSignUp.add(ccp1);
        studentSignUp.add(signUp);
        studentSignUp.setLayout(null);
        studentSignUp.setBounds(0, 0, 1000, 700);
        studentSignUp.setBackground(Color.green);
        studentSignUp.setVisible(true);

        signupComplete = new JPanel();

        l2 = new JLabel("Account has been successfully created!");
        l2.setBounds(300, 50, 400, 80);
        l2.setFont(bigFont);

        returnToLogin = new JButton();
        returnToLogin.setBounds(300, 150, 70, 30);
        returnToLogin.addActionListener(this);
        returnToLogin.setOpaque(false);
        returnToLogin.setContentAreaFilled(false);
        returnToLogin.setBorderPainted(true);
        returnToLogin.setForeground(Color.BLACK);

        returnToSignup = new JButton();
        returnToSignup.setBounds(300, 200, 70, 30);
        returnToSignup.addActionListener(this);
        returnToSignup.setOpaque(false);
        returnToSignup.setContentAreaFilled(false);
        returnToSignup.setBorderPainted(true);
        returnToSignup.setForeground(Color.BLACK);

        signupComplete.add(l2);
        signupComplete.add(returnToLogin);
        signupComplete.add(returnToSignup);
        signupComplete.setLayout(null);
        signupComplete.setBounds(0, 0, 1000, 700);
        signupComplete.setBackground(Color.green);
        signupComplete.setVisible(false);

        studentSignupFrame.add(studentSignUp);
        studentSignupFrame.add(signupComplete);
        studentSignupFrame.setLayout(null);
        studentSignupFrame.setTitle("Student Signup - Student Management System");
        studentSignupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentSignupFrame.setSize(1000, 700);
        studentSignupFrame.setLocationRelativeTo(null);
        studentSignupFrame.setVisible(true);
    }

    public void addStudent(Student s) {
        int count = 0;

        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = s;
                count++;
                this.students = students;
                break;
            }
        }
        if (count == 0) {
            System.out.println("Account not added");
        } else {
            System.out.println("Account added");
        }
    }

    public Student[] getStudents() {
        return students;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == signUp) {
            String name = tf1.getText();
            String rollNo = tf2.getText();
            String email = tf3.getText();
            String contactNumber = tf4.getText();
            String bloodGroup = (String) bloodGroupComboBox.getSelectedItem();
            String gender = (String) genderComboBox.getSelectedItem();
            String pass = new String(cp1.getPassword());
            String confPass = new String(ccp1.getPassword());

            if (name != null && rollNo != null && email != null && contactNumber != null && pass.equals(confPass)) {
                Student s = new Student(name, rollNo, email, contactNumber, bloodGroup, gender, pass);
                addStudent(s);
                studentSignUp.setVisible(false);
                signupComplete.setVisible(true);
            }
        }

        if (e.getSource() == returnToLogin) {
            studentSignupFrame.setVisible(false);
            new Login(students);
        }

        if (e.getSource() == returnToSignup) {
            signupComplete.setVisible(false);
            studentSignUp.setVisible(true);
        }
    }
}
