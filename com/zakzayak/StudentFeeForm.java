/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zakzayak;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class StudentFeeForm extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3;
    private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton b1,b2;
    Choice c1;
    private String[] course={"b_tech", "m_tech", "mba", "bba", "bca", "bsc", "mca", "msc" };
    private String[] sem = { "8", "4", "4", "6", "6", "6", "4", "4"};
    private String[] column = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII"};
    private String[] fees = {"43000", "81000", "65000", "25000", "32000", "18000", "36000"};
	private int code = -1;
	private int index,i;
    public static void main(String[] args) {
        new StudentFeeForm().setVisible(true);
    }


    public StudentFeeForm() {
        super("Student Fee Form");
	setBounds(700, 200, 400, 450);
	setResizable(false);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
	c1 = new Choice();

	c1.setForeground(new Color(47, 79, 79));
	c1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	c1.add("--Select--");
	c1.addItemListener(new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			b1.setVisible(true);
			try{
				conn c = new conn();
				index= comboBox_3.getSelectedIndex()-1;
				ResultSet rs = c.s.executeQuery("select * from student where rollno = '"+c1.getSelectedItem()+"'");
				while(rs.next()){
					t2.setText(rs.getString("name"));
					t3.setText(rs.getString("fathers_name"));
					t1.setText(fees[index]);
				}
				String query = new String("select * from " + course[index] + " where rollno = '"+c1.getSelectedItem()+"'");
				ResultSet resultSet = c.s.executeQuery(query);
				while(resultSet.next()) {
					for(i = 1; i <= Integer.parseInt(sem[index]); i++ ) {
						if(resultSet.getString(i) == null)
							break;
					}
					String update = "update " + course[index] + " set " + column[i-2] + " = " + fees[index] ;
					//System.out.println(update);
					comboBox_2.setSelectedIndex(i-2);
					if(i>=Integer.parseInt(sem[index])) {
						JOptionPane.showMessageDialog(null, "Your fee is complete!");
						t1.setText("Fee Completed!!");
						b1.setVisible(false);
					} else
						b1.setVisible(true);
				}
			}catch(Exception ex) { }
		}
	});
        
	JLabel l1 = new JLabel("Select Roll No");
	l1.setForeground(new Color(25, 25, 112));
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(64, 63, 102, 22);
	contentPane.add(l1);

	JLabel l2 = new JLabel("Name");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(64, 97, 102, 22);
	contentPane.add(l2);

	JLabel l3 = new JLabel("Father's Name");
	l3.setForeground(new Color(25, 25, 112));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(64, 130, 102, 22);
	contentPane.add(l3);

	JLabel l4 = new JLabel("Branch");
	l4.setForeground(new Color(25, 25, 112));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(64, 209, 102, 22);
	contentPane.add(l4);

        JLabel l5 = new JLabel("Semester");
	l5.setForeground(new Color(25, 25, 112));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(64, 242, 102, 22);
	contentPane.add(l5);

	JLabel l6 = new JLabel("Total Payable");
	l6.setForeground(new Color(25, 25, 112));
	l6.setFont(new Font("Tahoma", Font.BOLD, 14));
	l6.setBounds(64, 275, 102, 22);
	contentPane.add(l6);

	c1.setBounds(174, 66, 156, 20);
	contentPane.add(c1);

	t2 = new JTextField();
	t2.setForeground(new Color(47, 79, 79));
	t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t2.setColumns(10);
	t2.setBounds(174, 100, 156, 20);
	t2.setEditable(false);
	contentPane.add(t2);

	t3 = new JTextField();
	t3.setForeground(new Color(47, 79, 79));
	t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t3.setColumns(10);
	t3.setBounds(174, 133, 156, 20);
	t3.setEditable(false);
	contentPane.add(t3);


	comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] { "Mechanical", "CSE", "IT", "Civil", "Others", "Computer Science" }));
	comboBox.setForeground(new Color(47, 79, 79));
	comboBox.setEnabled(false);
	comboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	comboBox.setBounds(176, 211, 154, 20);
	contentPane.add(comboBox);

	comboBox_2 = new JComboBox();
	comboBox_2.setModel(
			new DefaultComboBoxModel(new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th" }));
	comboBox_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	comboBox_2.setForeground(new Color(47, 79, 79));
	comboBox_2.setBounds(176, 244, 154, 20);
	comboBox_2.setEnabled(false);
	contentPane.add(comboBox_2);
        
	t1 = new JTextField();
	t1.setForeground(new Color(47, 79, 79));
	t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t1.setColumns(10);
	t1.setEditable(false);
	t1.setBounds(176, 275, 154, 20);
	add(t1);
        
	b1 = new JButton("Pay");
	b1.addActionListener(this);
	b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	b1.setBounds(64, 321, 111, 33);
    b1.setBackground(Color.BLACK);
	b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	b2.setBounds(198, 321, 111, 33);
	b2.setBackground(Color.BLACK);
    b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	JLabel l7 = new JLabel("Course");
	l7.setForeground(new Color(25, 25, 112));
	l7.setFont(new Font("Tahoma", Font.BOLD, 14));
	l7.setBounds(64, 173, 102, 22);
	contentPane.add(l7);

	comboBox_3 = new JComboBox();
	comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "-Select-","B.Tech", "M.Tech", "MBA", "BBA", "BCA", "Bsc", "MCA", "Msc" }));
	comboBox_3.setForeground(new Color(47, 79, 79));
	comboBox_3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	comboBox_3.setBounds(176, 176, 154, 20);
	contentPane.add(comboBox_3);
	comboBox_3.addItemListener(new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getItem() == "B.Tech" || e.getItem() == "M.Tech")
				comboBox.setSelectedItem("Mechanical");
			if(e.getItem() == "BCA" || e.getItem()== "MCA")
				comboBox.setSelectedItem("IT");
			if(e.getItem() == "MBA" || e.getItem() == "BBA")
				comboBox.setSelectedItem("Civil");
			if(e.getItem() == "Bsc" || e.getItem() == "Msc")
				comboBox.setSelectedItem("Computer Science");

			try{
				c1.removeAll();
				conn c = new conn();
				ResultSet rs = c.s.executeQuery("select * from student where course = '"+comboBox_3.getSelectedItem() +"';");
				c1.add("--Select--");
				while(rs.next()){
					c1.add(rs.getString("rollno"));
				}
			}catch(Exception ex) { }
			}
		});

	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(102, 205, 170), 2, true), "Fee-Form",
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
	panel.setBackground(new Color(211, 211, 211));
	panel.setBounds(10, 38, 358, 348);
        
        contentPane.setBackground(Color.WHITE);
        panel.setBackground(Color.WHITE);
        
	contentPane.add(panel);

    }
    
    public void actionPerformed(ActionEvent ae){
        try{
        	if(ae.getSource() == b1){
                try{
                	conn con = new conn();
					String fee = " " + (i-1) + " - " + sem[index];
                	String query = "select * from fee where rollno = '" + c1.getSelectedItem() + "'";
                	ResultSet rs =con.s.executeQuery(query);
                	if(!rs.next()) {
                		String update = "update fee set fee_paid = '" + fee + "'" ;
                		con.s.executeUpdate(update);
					} else {
						String sql = "insert into fee(rollno, name, fathers_name, course, branch, semester, fee_paid) values(?, ?, ?, ?, ?, ?, ?)";
						PreparedStatement st = con.c.prepareStatement(sql);
						st.setString(1, c1.getSelectedItem());
						st.setString(2, t2.getText());
						st.setString(3, t3.getText());
						st.setString(4, (String) comboBox_3.getSelectedItem());
						st.setString(5, (String) comboBox.getSelectedItem());
						st.setString(6, (String) comboBox_2.getSelectedItem());
						st.setString(7, fee);
						int i = st.executeUpdate();
						if (i > 0){
							JOptionPane.showMessageDialog(null, "Successfully Paid");
							this.setVisible(false);
						} else
							JOptionPane.showMessageDialog(null, "error");
					}
					String update = "update " + course[index] + " set " + column[i-2] + " = " + fees[index];
					con.s.executeUpdate(update);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            
            if(ae.getSource() == b2){
                this.setVisible(false);
            }
        }catch(Exception e){ }
    }
}

