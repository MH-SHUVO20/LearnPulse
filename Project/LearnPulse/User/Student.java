package User;

import javax.swing.*;
import java.awt.event.*;

import Dashboard.*;
import Login.*;

public class Student extends User {

  public Student(String name, String rollNo, String emailAddress, String password) {
    super(name, rollNo, emailAddress, password);
  }

  public String getName() {
    return name;
  }

  public String getRollNo() {
    return phoneNumber;
  }

  public String getEmailaddress() {
    return emailAddress;
  }

  public String getPassword() {
    return password;
  }

  public void showStudentDetails() {
    System.out.println("Name: " + name);
    System.out.println("Roll Number: " + phoneNumber);
    System.out.println("Email Address: " + emailAddress);
    System.out.println("Password: " + password);
  }
}

