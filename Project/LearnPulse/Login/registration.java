package swing.loginframe;

import javax.swing.*;
import java.awt.*;
import java.lang.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.Cursor;
import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;
import java.awt.EventQueue;
mport static javax.swing.JOptionPane.showMessageDialog;

public class registation extends JFrame {
   private Container background;
   private ImageIcon image;
   private JLabel title,subtitle, Name,Faname,Moname,byear,Email,Mnumber,Username,password,password2,gender;
   private JTextField name, Fname,Mname,Byear,email,mnumber, username;

   private JPasswordField Pass,cpass;
   private Font f,f2,b,c,font;
   private JRadioButton male,female;
   private ButtonGroup group;
    private JComboBox subject;
    private String [] subjectlist= {"Computer science and engineering","Electrical and electronics engineering","Mechanical engineering","Architectural engineering","Economic","Marketing and Management","Accounting"};
   private JButton register;
   public  registation()
   {
       image = new ImageIcon(getClass().getResource("atm.jpg"));

       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setLayout(null);
       this.setBounds(250,50,500,700);
       this.setLocationRelativeTo(null);
       this.setResizable(false);
       this.setTitle("Student Complain page");
       this.setIconImage(image.getImage());
       Background();
   }
   public void Background()
   {    font =new Font("Times New Roman",Font.PLAIN,17); // used for JRediobutton
       f =new Font("Times New Roman",Font.BOLD,20);  // JLabel used
       f2=new Font("Times New Roman",Font.PLAIN,22); // tpassword field used
       b =new Font("Times New Roman",Font.BOLD,26); // title used
       c =new Font("Times New Roman",Font.PLAIN,14); // subtitle used


       background=getContentPane();
       background.setBackground(new Color(12345));


       title= new JLabel();
       title.setText("Student Registration Form");
       title.setBounds(20,10,500,30);
       title.setForeground(Color.white);
       title.setFont(b);

       subtitle= new JLabel();
       subtitle.setText("Full is this form to register ");
       subtitle.setBounds(20,45,400,30);
       subtitle.setForeground(Color.white);
       subtitle.setFont(c);

       Name= new JLabel();
       Name.setText("Full-Name ");
       Name.setBounds(20,80,100,30);
       Name.setForeground(Color.white);
       Name.setFont(f);

       Faname= new JLabel();
       Faname.setText("Father-name");
       Faname.setBounds(20,120,120,30);
       Faname.setForeground(Color.white);
       Faname.setFont(f);

       Moname= new JLabel();
       Moname.setText("Mother-name");
       Moname.setBounds(20,160,120,30);
       Moname.setForeground(Color.white);
       Moname.setFont(f);

       byear= new JLabel();
       byear.setText("Date of Birth");
       byear.setBounds(20,200,120,30);
       byear.setForeground(Color.white);
       byear.setFont(f);

       Email= new JLabel();
       Email.setText("Email ");
       Email.setBounds(20,240,120,30);
       Email.setForeground(Color.white);
       Email.setFont(f);

       Mnumber= new JLabel();
       Mnumber.setText("Phone");
       Mnumber.setBounds(20,280,120,30);
       Mnumber.setForeground(Color.white);
       Mnumber.setFont(f);

       Username= new JLabel();
       Username.setText("Set Username");
       Username.setBounds(20,320,160,30);
       Username.setForeground(Color.white);
       Username.setFont(f);

       password= new JLabel();
       password.setText("Set Password");
       password.setBounds(20,360,160,30);
       password.setForeground(Color.white);
       password.setFont(f);

       password2= new JLabel();
       password2.setText("confirm Password");
       password2.setBounds(20,400,160,30);
       password2.setForeground(Color.white);
       password2.setFont(f);


       gender= new JLabel();
       gender.setText("Gender :");
       gender.setBounds(20,440,120,30);
       gender.setForeground(Color.white);
       gender.setFont(f);

       // end of jlabel

       name= new JTextField();
       name.setBounds(142,80,250,30);
       name.setBackground(Color.LIGHT_GRAY);

       Fname= new JTextField();
       Fname.setBounds(142,120,250,30);
       Fname.setBackground(Color.LIGHT_GRAY);

       Mname= new JTextField();
       Mname.setBounds(142,160,250,30);
       Mname.setBackground(Color.LIGHT_GRAY);

       Byear= new JTextField();
       Byear.setBounds(142,200,250,30);
       Byear.setBackground(Color.LIGHT_GRAY);

       email= new JTextField();
       email.setBounds(142,240,250,30);
       email.setBackground(Color.LIGHT_GRAY);

       mnumber= new JTextField();
       mnumber.setBounds(142,280,250,30);
       mnumber.setBackground(Color.LIGHT_GRAY);

       username= new JTextField();
       username.setBounds(150,320,250,30);
       username.setBackground(Color.LIGHT_GRAY);

       // end of Jtextfeild

       Pass= new JPasswordField();
       Pass.setBounds(150,360,250,30);
       Pass.setBackground(Color.LIGHT_GRAY);
       Pass.setFont(f2);

       cpass= new JPasswordField();
       cpass.setBounds(180,400,225,30);
       cpass.setBackground(Color.LIGHT_GRAY);
       cpass.setFont(f2);

       // end of JPassword

       male=new JRadioButton("Male");
       male.setBackground(new Color(12345));
       male.setForeground(Color.white);
       male.setFont(font);
       male.setFocusable(false);
       male.setBounds(110,440,80,30);

       female=new JRadioButton("Female");
       female.setBackground(new Color(12345));
       female.setForeground(Color.white);
       female.setFont(font);
       female.setFocusable(false);
       female.setBounds(200,440,120,30);

       group= new ButtonGroup();
       group.add(male);
       group.add(female);

       // end of JRedioButton

       subject= new JComboBox(subjectlist);
       subject.setBounds(20,480,250,20);

       register= new JButton("register");
       register.setBounds(20,580,80,30);
       register.setFocusable(false);
       register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));









// add everything in frame
       background.add(title);
       background.add(subtitle);
       background.add(Name);
       background.add(Faname);
       background.add(Moname);
       background.add(byear);
       background.add(Mnumber);
      background.add(Email);
     background.add(Username);
      background.add(password);
      background.add(password2);
      background.add(gender);

      // add jlanel
       background.add(name);
       background.add(Fname);
       background.add(Mname);
       background.add(Byear);
       background.add(email);
       background.add(mnumber);
       background.add(username);

       //end of textfield
       background.add(Pass);
       background.add(cpass);

       //end of Jpass
       background.add(male);
       background.add(female);
       //end of JRediobutton
       background.add(register);
       // adding of jcombobox
       background.add(subject);

   }
    public static void main(String[] args) {

        registation frame= new registation();
        frame.setVisible(true);

    }

}
