/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zakzayak;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Marks extends JFrame{

   JTextArea t1;
   JPanel p1;
   
   Marks(){}
   Marks(String str){
       setSize(500,500);
       setLayout(new BorderLayout());
       
       p1 = new JPanel();
       setResizable(false);
       t1 = new JTextArea(50,15);
       JScrollPane jsp = new JScrollPane(t1);
       t1.setEditable(false);
       t1.setFont(new Font("Senserif",Font.ITALIC,18));
       
       add(p1,"North");
       
       add(t1,"Center");
       
       setLocation(450,200);
       mark(str);
   }
   
   public void mark(String s){
    try{
           conn c = new conn();
           String str = new String("select marks.rollno, marks1,marks2,marks3,marks4,marks5,subject1,subject2,subject3,subject4,subject5 from marks inner join subject on marks.rollno = subject.rollno;");

           t1.setText(" |----------------------------------------------------------------------------|\n");
           t1.append(" |                              Result of Examination                          |\n");
           t1.append(" |----------------------------------------------------------------------------|\n");
           t1.append(" |                                                   Roll No: "+s+"|\n");
           t1.append(" |----------------------------------------------------------------------------|\n");
           t1.append(" | S.No.   Subjects                                            Marks           |\n");
           int i  =1;
           ResultSet rs = c.s.executeQuery(str);
            if(rs.next()){
                t1.append(" +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                t1.append("\n |    "+ i++ +"      "+rs.getString("subject1") + "\t\t" + rs.getString("marks1")+ "");
                t1.append("\n |    "+ i++ +"      "+rs.getString("subject2") + "\t\t" + rs.getString("marks2")+ "");
                t1.append("\n |    "+ i++ +"      "+rs.getString("subject3") + "\t\t" + rs.getString("marks3")+ "");
                t1.append("\n |    "+ i++ +"      "+rs.getString("subject4") + "\t\t" + rs.getString("marks4")+ "");
                t1.append("\n |    "+ i++ +"      "+rs.getString("subject5") + "\t\t" + rs.getString("marks5")+ "\n");
                t1.append(" |----------------------------------------------------------------------------|\n");

                t1.append("\n");
            }
       }catch(Exception e){
           e.printStackTrace();
       }
   }
   
   public static void main(String[] args){
       new Marks().setVisible(true);
   }
}