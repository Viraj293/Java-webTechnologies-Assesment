package com.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Library implements ActionListener {
       
	JFrame f;
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2,b3,b4;  
	
	
  Library() {
	  f = new JFrame("My Library Application is..");
	  f.setVisible(true);
	  f.setSize(400,440);
	  f.setLayout(null);
	  f.setResizable(false);
	  
	  l1=new JLabel("ID :");
	  l2=new JLabel("BookName :");
	  l3=new JLabel("Author :");
	  l4=new JLabel("Quantity :");
	  l5=new JLabel("Price :");
     
	     t1 = new JTextField(20);
		 t2= new JTextField(20);
		 t3= new JTextField(20);
		 t4= new JTextField(20);
		 t5= new JTextField(20);
	  
		 b1 = new JButton("Insert");
		 b2 = new JButton("Serch");
		 b3 = new JButton("Update");
		 b4 = new JButton("Delete");
		 
		 f.add(l1);
		 f.add(t1);
		 
		 f.add(l2);
		 f.add(t2);
		 
		 f.add(l3);
		 f.add(t3);
		 
		 f.add(l4);
		 f.add(t4);
		 
		 f.add(l5);
		 f.add(t5);
		 
		 f.add(b1);
		 f.add(b2);
		 f.add(b3);
		 f.add(b4);
		 
		 l1.setBounds(50, 050, 100, 20);
		 l2.setBounds(50, 100, 100, 20);
		 l3.setBounds(50, 150, 100, 20);
		 l4.setBounds(50, 200, 100, 20);
		 l5.setBounds(50, 250, 100, 20);
		 
		 t1.setBounds(150, 050, 180, 20);
		 t2.setBounds(150, 100, 180, 20);
		 t3.setBounds(150, 150, 180, 20);
		 t4.setBounds(150, 200, 180, 20);
		 t5.setBounds(150, 250, 180, 20);
		 
		 b1.setBounds(50, 300, 100, 20);
		 b2.setBounds(230, 300, 100, 20);
		 b3.setBounds(50, 350, 100, 20);
		 b4.setBounds(230, 350, 100, 20); l1.setBounds(50, 050, 100, 20);
		 l2.setBounds(50, 100, 100, 20);
		 l3.setBounds(50, 150, 100, 20);
		 l4.setBounds(50, 200, 100, 20);
		 l5.setBounds(50, 250, 100, 20);
		 
		 t1.setBounds(150, 050, 180, 20);
		 t2.setBounds(150, 100, 180, 20);
		 t3.setBounds(150, 150, 180, 20);
		 t4.setBounds(150, 200, 180, 20);
		 t5.setBounds(150, 250, 180, 20);
		 
		 b1.setBounds(50, 300, 100, 20);
		 b2.setBounds(230, 300, 100, 20);
		 b3.setBounds(50, 350, 100, 20);
		 b4.setBounds(230, 350, 100, 20);
		 
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);
		 b4.addActionListener(this);
		 
  }
	public static void main(String[] args) {
	
		new Library();
	}
	
	public void actionPerformed(ActionEvent e) {
	   if (e.getSource()==b1)
	   {
		   try {
			   Class.forName("com.mysql.jdbc.Deriver");//load the deriver
			   Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			  String sql ="insert into Details(bname,aname,quantity,price) values(?,?,?,?)";
			  Statement stmt= (Statement) conn.createStatement();
			  stmt.execute(sql);
			  System.out.println("Data Insert Sucessfully");
			  t2.setText("");
			  t3.setText("");
			  t4.setText("");
			  t5.setText("");
		} catch (Exception e2) {
			e2.printStackTrace();		}
	   }
	   else if (e.getSource()==b2) {
		   try {
			   Class.forName("com.mysql.jdbc.Deriver");
			   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
				  String sql = "Select * from Details Where id=?";
				  PreparedStatement pst =(PreparedStatement) conn.prepareStatement(sql);
                  pst.setInt(1,Integer.parseInt(t1.getText()));
                  ResultSet rs =pst.executeQuery();
           if (rs.next())
           {
        	   t2.setText(rs.getString("bname"));
         	  t3.setText(rs.getString("aname"));
         	  t4.setText(rs.getString("quantity"));
         	  t5.setText(rs.getString("price"));
         	  System.out.println("Data Is Found");
           }
           else {
        	   t2.setText("");
 			  t3.setText("");
 			  t4.setText("");
 			  t5.setText("");
 			  System.out.println("Id Not Find.");
           }
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		   
	   }
	   else if(e.getSource()==b3) {
		   try {
			Class.forName("com.mysql.jdbc.Deriver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			String sql ="update Details set bname=?,aname=?,quantity=?,price=? where id=?";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, t2.getText());
			pst.setString(2, t3.getText());
			pst.setString(3, t4.getText());
			pst.setString(4, t5.getText());
			pst.setInt(5, Integer.parseInt(t1.getText()));
			pst.executeUpdate();
			
			t1.setText("");	
			   t2.setText("");
			   t3.setText("");
			   t4.setText("");
			   t5.setText("");
			   System.out.println("Data Updated Successfully.");
			   
			   
			   
		} catch (Exception e2) {
			e2.printStackTrace();		}
	   }
	   else if (e.getSource()==b4) {
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			String sql ="delete from Details where id=?";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(t1.getText()));
			pst.executeUpdate();
			
			   t1.setText("");	
			   t2.setText("");
			   t3.setText("");
			   t4.setText("");
			   t5.setText("");
			   System.out.println("Data Deleted Successfully.");
			  
		} catch (Exception e2) {
			e2.printStackTrace();
		} 
	   }
	}
	
}
	

	
	
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

