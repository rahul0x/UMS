package com.zakzayak;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Fee extends JFrame implements ActionListener{

    JLabel l1,l2,l3;
    JTable t1;
    JButton b1,b2,b3;
    JTextField t2;
    private String[] course={"b_tech", "m_tech", "mba", "bba", "bca", "bsc", "mca", "msc" };
    private String[] option= new String[] { "B.Tech", "M.Tech", "MBA", "BBA", "BCA", "Bsc", "MCA", "Msc" };
    private String[] sem = { "8", "4", "4", "6", "6", "6", "4", "4"};
    private String[] column = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII"};
    String x[] = {"Name","Father's Name","Mother's Name","Date of Birth","Address","Phone","Email","Class X(%)", "Class XII(%)", "Aadhar No","Roll No","Course","Branch"};
    String y[][] = new String[20][13];
    int i=0, j=0;
    Fee(){
        super("Student Fee Status");
        setSize(1260,650);
        setLocation(200,200);
        setLayout(null);

        l1 = new JLabel("Enter roll number to delete Student : ");
        l1.setBounds(50,360,400,30);
        l1.setFont(new Font("serif",Font.BOLD,20));
        add(l1);

        t2 = new JTextField();
        t2.setBounds(400,360,200,30);
        add(t2);

        b1 = new JButton("Fetch");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(620, 360, 100 ,30);
        add(b1);


        b1.addActionListener(this);


        try{
            conn c1  = new conn();
            String s1 = "select * from fee where rollno = '"+ t2.getText() + "'";
            ResultSet rs  = c1.s.executeQuery(s1);
            while(!rs.next()){
                String course = rs.getString("course");
                int index;
                for(int i = 0; i <= option.length; i++) {
                    if (course.equals(option[i]))
                        break;
                }
                System.out.println(i);


                y[i][j++]=rs.getString("name");
                y[i][j++]=rs.getString("fathers_name");
                y[i][j++]=rs.getString("mothers_name");
                y[i][j++]=rs.getString("dob");
                y[i][j++]=rs.getString("address");
                y[i][j++]=rs.getString("phone");
                y[i][j++]=rs.getString("email");
                y[i][j++]=rs.getString("class_x");
                y[i][j++]=rs.getString("class_xii");
                y[i][j++]=rs.getString("aadhar");
                y[i][j++]=rs.getString("rollno");
                y[i][j++]=rs.getString("course");
                y[i][j++]=rs.getString("branch");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);

        }catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(20,20,1200,330);
        add(sp);

        getContentPane().setBackground(Color.WHITE);

        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae) {

        conn c1 = new conn();

        if (ae.getSource() == b1) {
            try {
                String a = t2.getText();
                String q = "select * from fee where rollno = '" + a + "'";
                c1.s.executeUpdate(q);

                this.setVisible(false);
                new StudentDetails().setVisible(true);
            } catch (Exception e) {
            }
        }
    }
    public static void main(String ...args){
        new Fee().setVisible(true);
    }

}
