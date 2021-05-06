package com.zakzayak;

import jdk.nashorn.internal.scripts.JO;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Random;
import javax.swing.*;

class AddStudent implements ActionListener{

    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id15,id16,id17,lab,lab1,lab2;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
    JButton b,b1,b2,b3;
    JComboBox c1,c2;
    private String[] course={"b_tech", "m_tech", "bba", "mba", "bca", "mca", "bsc", "msc" };
    private int code = -1;
    private String data[];
    private  String field[] = {"Name", "Father's Name", "Mother's Name", "DoB", "Address", "Phone", "Email", "Class X", "Class XII", "Aadhar", "Course"};

    public AddStudent(){
        f = new JFrame("Add Student");
        f.setBackground(Color.white);
        f.setLayout(null);
        f.setResizable(false);
        id15=new JLabel();
        id15.setBounds(0,0,900,700);
        id15.setLayout(null);
        ImageIcon img = new ImageIcon("C:\\Users\\Rahul\\IdeaProjects\\CMS\\src\\com\\zakzayak\\icons\\student.jpg");
        Image i3 = img.getImage().getScaledInstance(1220, 700,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        id15.setIcon(icc3);

        JLabel label= new JLabel("Copyright © RAHUL");
        label.setBounds(750,620, 150, 20);
        f.add(label);

        id8 = new JLabel("New Student Details");
        id8.setBounds(320,30,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,25));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);

 
        id1 = new JLabel("Name");
        id1.setBounds(50,150,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id1);

        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        id15.add(t1);

        id2 = new JLabel("Father's Name");
        id2.setBounds(400,150,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(600,150,150,30);
        id15.add(t2);

        id3= new JLabel("Mother's Name");
        id3.setBounds(50,200,150,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id3);

        t3=new JTextField();
        t3.setBounds(200,200,150,30);
        id15.add(t3);

        id4= new JLabel("DOB (dd/mm/yyyy)");  
        id4.setBounds(400,200,200,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id4);

        t4=new JTextField();
        t4.setBounds(600,200,150,30);
        id15.add(t4);

        id5= new JLabel("Address");
        id5.setBounds(50,250,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id5);

        t5=new JTextField();
        t5.setBounds(200,250,150,30);
        id15.add(t5);

        id6= new JLabel("Phone");
        id6.setBounds(400,250,100,30);
        id6.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id6);

        t6=new JTextField();
        t6.setBounds(600,250,150,30);
        id15.add(t6);

        id7= new JLabel("Email Id");
        id7.setBounds(50,300,100,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id7);

        t7=new JTextField();
        t7.setBounds(200,300,150,30);
        id15.add(t7);

        id9= new JLabel("Class X(%)");
        id9.setBounds(400,300,130,30);
        id9.setFont(new Font("serif",Font.BOLD,20));    
        id15.add(id9);

        t8=new JTextField();
        t8.setBounds(600,300,150,30);
        id15.add(t8);

        id10= new JLabel("Class XII(%)");
        id10.setBounds(50,350,130,30);
        id10.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id10);

        t9=new JTextField();
        t9.setBounds(200,350,150,30);
        id15.add(t9);


        id11= new JLabel("Aadhar No");
        id11.setBounds(400,350,100,30);
        id11.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id11);

        t10=new JTextField();
        t10.setBounds(600,350,150,30);
        id15.add(t10);


        lab=new JLabel("Course");
        lab.setBounds(400,400,150,30);
	lab.setFont(new Font("serif",Font.BOLD,20));
        id15.add(lab);
            
        String course[] = {"-Select-","B.Tech", "M.Tech", "MBA", "BBA", "BCA", "Bsc", "MCA", "Msc"};
        c1 = new JComboBox(course);
        c1.setBackground(Color.WHITE);
        c1.setBounds(600,400,150,30);
        id15.add(c1);
        c1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getItem() == "B.Tech" || e.getItem() == "M.Tech")
                    c2.setSelectedItem("Mechanical");
                if(e.getItem() == "BCA" || e.getItem()== "MCA")
                    c2.setSelectedItem("IT");
                if(e.getItem() == "MBA" || e.getItem() == "BBA")
                    c2.setSelectedItem("Civil");
                if(e.getItem() == "Bsc" || e.getItem() == "Msc")
                    c2.setSelectedItem("Computer Science");

                if(c1.getSelectedItem() == "B.Tech") code = 0;
                if(c1.getSelectedItem() == "M.Tech") code = 1;
                if(c1.getSelectedItem() == "BBA") code = 2;
                if(c1.getSelectedItem() == "MBA") code = 3;
                if(c1.getSelectedItem() == "BCA") code = 4;
                if(c1.getSelectedItem() == "MCA") code = 5;
                if(c1.getSelectedItem() == "Bsc") code = 6;
                if(c1.getSelectedItem() == "Msc") code = 7;
            }
        });
        
        lab2=new JLabel("Branch");
        lab2.setBounds(50,400,150,30);
	lab2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(lab2);
        
        String branch[] = {"Computer Science","IT","Others","Mechanical","Civil"};
        c2 = new JComboBox(branch);
        c2.setEnabled(false);
        c2.setBackground(Color.WHITE);
        c2.setBounds(200,400,150,30);
        id15.add(c2);
        
        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250,550,150,40);
        
        id15.add(b);

        b1=new JButton("Cancel");   
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450,550,150,40);
        
        id15.add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(900,700);
        f.setLocation(400,150);
    }

    public void actionPerformed(ActionEvent ae){

        String a = t1.getText();
        if(!validateString(a, 0)) return;
        String bb = t2.getText();
        if(!validateString(bb, 1)) return;
        String c = t3.getText();
        if(!validateString(c, 2)) return;
        String d = t4.getText();
        if(!validateDob(d)) return;
        String e = t5.getText();
        if(!validateString(e,4)) return;
        String ff = t6.getText();
        if(!validatePhone(ff)) return;
        String g = t7.getText();
        if(!validateString(g,6)) return;
        String h = t8.getText();
        if(!validateMarks(h)) return;
        String i = t9.getText();
        if(!validateMarks(i)) return;
        String j = t10.getText();
        if(!validateAdhar(j)) return;
        String l = (String)c1.getSelectedItem();
        if(!validateCourse(l)) return;
        String m = (String)c2.getSelectedItem();

        data = new String[]{a, bb, c, e, d, ff, g, h, i, j, l, m};

        if(ae.getSource() == b){

            try{
                Date roll = new java.util.Date();
                Long rollno = roll.getTime();
                conn cc = new conn();
                String q = "insert into student values('"+a+"','"+bb+"','"+c+"','"+d+"','"+e+"','"+ff+"','"+g+"','"+h+"','"+i+"','"+j+"','"+rollno+"','"+l+"','"+m+"')";
                cc.s.executeUpdate(q);
                cc.s.executeUpdate("insert into "+course[code] +"(rollno) value("+rollno+")");
                JOptionPane.showMessageDialog(null,"Student Details Inserted Successfully");
                f.setVisible(false);
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        }else if(ae.getSource() == b1){
            f.setVisible(false);
        }
    }

    private boolean validateCourse(String datum) {
        if(datum.equals("-Select-")) {
            JOptionPane.showMessageDialog(null, "Select course");
            return false;
        }
        return true;
    }

    private boolean validateMarks(String datum) {
        String[] stmt = { "Length Not more than 4 digit!"};
        int code = -1;
        String str = datum;
        int length = str.length();
        if(!(length <= 5))  code = 0;
        try {
            Integer.valueOf(str);
        } catch (NumberFormatException e) {
            try {
                Float.valueOf(str);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null," Incorrect Marks ");
                return false;
            }
        }
        if(!(code == -1)) {
            JOptionPane.showMessageDialog(null, stmt[code]);
            return false;
        }
        return true;
    }

    private boolean validatePhone(String datum) {
        try {
            long isInt = Long.parseLong(datum);
            if(datum.length() != 10) {
                JOptionPane.showMessageDialog(null, "Enter 10 digits Mobile No");
                return false;
            }
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, " Enter Number only on Mobile ");
            return false;
        }
        return true;
    }

    private boolean validateAdhar(String datum) {
        try {
            long isInt = Long.parseLong(datum);
            if(datum.length() != 12) {
                JOptionPane.showMessageDialog(null, "Enter 10 digits Aadhar No");
                return false;
            }
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, " Enter Number only on Aadhar ");
            return false;
        }
        return true;
    }

    private boolean validateString(String datum, int i) {
        int size = datum.length();
        if(size == 0) {
            JOptionPane.showMessageDialog(null, field[i] + " Cannot be blank!");
            return false;
        }
        if(size <= 2) {
            JOptionPane.showMessageDialog(null, " Please Re-Check " + field[i] + " Again");
            return false;
        }
        try {
            int isInt = Integer.parseInt(datum);
            JOptionPane.showMessageDialog(null, "Incorrect Data Entered in " + field[i]);
            return false;
        } catch (NumberFormatException n) { }
        return true;
    }

    private boolean validateDob(String datum) {
        int code = -1;
        String str = datum;
        int size = str.length();
        if(!(size == 10)) {
            JOptionPane.showMessageDialog(null, "Incorrect DoB");
            return false;
        }
        char c = str.charAt(2);
        char c1 = str.charAt(5);
        if(!((c1 == c) && (c1 == '/'))) code = 1;
        for(int j=0; j< str.length(); j++)
            if(!((j==2) || (j==5)))
                try {
                    int isInt = Integer.parseInt(String.valueOf(str.charAt(j)));
                } catch (NumberFormatException n) {
                    JOptionPane.showMessageDialog(null, "Enter correct DoB");
                    return false;
                }
        if(code!= -1) {
            JOptionPane.showMessageDialog(null, "Incorrect DoB");
            return false;
        }
        return true;
    }

    public static void main(String[ ] arg){
        new AddStudent().f.setVisible(true);
    }
}