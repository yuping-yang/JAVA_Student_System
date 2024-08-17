package pkg;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
public class users extends JFrame 
{
	JLabel l1=new JLabel("input username");  
	JLabel l2=new JLabel("input password");
	JTextField t1=new JTextField(10);
	JTextField t2=new JTextField(15);
	JLabel l3=new JLabel("original username");  
	JLabel l4=new JLabel("original password");
	JTextField t3=new JTextField(10);
	JTextField t4=new JTextField(15);
	JLabel l5=new JLabel("new password");
	JTextField t5=new JTextField(15);
	JButton b1=new JButton("add account");
	JButton b2=new JButton("delete account");
	JButton b3=new JButton("modify account");
	JPanel jp=new JPanel();
	int i=0;
	String n;
	String p;
	String p2;
    String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=dbstu";
    String userName="sa"; 
    String userPwd="sunshinehvd"; 

    
    public users(int i){
    	if(i==1)
    	{
    		  t1.setText("");
    		  t2.setText("");
    		  setLayout(null);
    		  b1.addActionListener(new MyActionListener());
    		  l1.setBounds(new Rectangle(20,20,70,30));
    		  l1.setBackground(Color.white);
    		  t1.setBackground(Color.white);
    		  t1.setBounds(new Rectangle(100,20,120,30));
    	      l2.setBounds(new Rectangle(20,55,70,30));
    		  l2.setBackground(Color.white);
    		  t2.setBackground(Color.white);
    		  t2.setBounds(new Rectangle(100,55,120,30));
    		  jp.setBounds(new Rectangle(60,100,120,35));
    		  add(l1);
    		  add(t1);
    		  add(l2);
    		  add(t2);
    		  jp.add(b1);
    		  add(jp);
    		  setTitle("add account");
    		  setSize(270, 180);  
    		  setLocation(600,100);
    		  setVisible(true);
    		  this.addWindowListener(new WindowAdapter() {
    				public void windowClosing(WindowEvent we) {
    					dispose();	}
    			}); 
    	   }
    	
    	if(i==2)
    	{
    		  t1.setText("");
    		  t2.setText("");
    		  setLayout(null);	   
    		  b2.addActionListener(new MyActionListener());
    		  l1.setBounds(new Rectangle(20,20,70,30));
    		  l1.setBackground(Color.white);
    		  t1.setBackground(Color.white);
    		  t1.setBounds(new Rectangle(100,20,120,30));
    	      l2.setBounds(new Rectangle(20,55,70,30));
    		  l2.setBackground(Color.white);
    		  t2.setBackground(Color.white);
    		  t2.setBounds(new Rectangle(100,55,120,30));
    		  jp.setBounds(new Rectangle(60,100,120,35));
    		  add(l1);
    		  add(t1);
    		  add(l2);
    		  add(t2);
    		  jp.add(b2);
    		  add(jp);
    		  setTitle("delete account");
    		  setSize(270, 180);  
    		  setLocation(600,100);
    		  setVisible(true);
    		  this.addWindowListener(new WindowAdapter() {
  				public void windowClosing(WindowEvent we) {
  					dispose();	}
  			}); 
    	   }
    	if(i==3)
    	{
    		setLayout(null);	   
    		  b3.addActionListener(new MyActionListener());
    		  l3.setBounds(new Rectangle(20,20,70,30));
    		  l3.setBackground(Color.white);
    		  t3.setBackground(Color.white);
    		  t3.setBounds(new Rectangle(100,20,120,30));
    	      l4.setBounds(new Rectangle(20,55,70,30));
    		  l4.setBackground(Color.white);
    		  t4.setBackground(Color.white);
    		  t4.setBounds(new Rectangle(100,55,120,30));    		    		 
    	      l5.setBounds(new Rectangle(20,135,70,30));
    		  l5.setBackground(Color.gray);	  
    		  t5.setBackground(Color.white);
    		  t5.setBounds(new Rectangle(100,135,120,30));    		  
    		  jp.setBounds(new Rectangle(60,185,120,35));
    		  add(l3);
    		  add(t3);
    		  add(l4);
    		  add(t4);
    		  add(l5);
    		  add(t5);
    		  jp.add(b3);
    		  add(jp);
    		  setTitle("modify account");
    		  setSize(260, 270);  
    		  setLocation(600,100);
    		  setVisible(true);
    		  this.addWindowListener(new WindowAdapter() {
  				public void windowClosing(WindowEvent we) {
  					dispose();	}
  			}); 
    	}

    	
    	}
    	class MyActionListener implements ActionListener{
    		   public void actionPerformed(ActionEvent e){
    		      if (e.getSource()==b1){
    					  n=t1.getText();
    					  p=t2.getText();
    				 if (n.equals("")||p.equals(""))  
    				   JOptionPane.showMessageDialog(null,"Username or password cannot be empty");	
    				 else{	
    					 try {
    						  Connection con=DriverManager.getConnection(dbURL,userName,userPwd);  
    						  Statement s=con.createStatement(); 
    						  PreparedStatement ps=con.prepareStatement("insert into Users values(?,?)");
    					      ps.setString(1, n);
    					      ps.setString(2, p);
    					      int m= ps.executeUpdate( ); 
    					      if(m!=0){
    					    	  //System.out.println("done");
    					    	  JOptionPane.showMessageDialog(null,"add account - done");
    					    	  t1.setText(null);
    					    	  t2.setText(null);
    					      }
    						  s.close();  
    					      con.close();  
    						}
    						catch(SQLException e1) 
    					     { System.out.println("SQLException 1: " +e1.getMessage());  }
    				 
    		        }  
    		     }
       if (e.getSource()==b2){
 			n=t1.getText();
 		    p=t2.getText();
 		    if (n.equals("")||p.equals(""))  
 				   JOptionPane.showMessageDialog(null,"Username or password cannot be empty");	
 		    else{	
 		    	try {	 
 				Connection con=DriverManager.getConnection(dbURL,userName,userPwd);  
 				Statement s=con.createStatement();
 				PreparedStatement ps=con.prepareStatement("delete from Users where username=? and password=?");
 					    ps.setString(1,n); 
 					    ps.setString(2,p);
 						int m=ps.executeUpdate( ); 
 						if(m!=0){
 					       //System.out.println("done");
 					       JOptionPane.showMessageDialog(null,"delete account - done");
 					       t1.setText(null);
 					       t2.setText(null);
 					       }	    				
 					    s.close();  
 					    con.close();  
 					}
 		    	//}
 					catch(SQLException e1)
 					   {
 						JOptionPane.showMessageDialog(null,"username or password is incorrect, and you are not authorized to delete user information!");
 						System.out.println("SQLException 3: " +e1.getMessage( ));
 						System.out.println(n);
 					   }
 			 }
 		   }
        
    	if(e.getSource()==b3){
    		 n=t3.getText();
    		 p=t4.getText();
    		 p2=t5.getText();;
    		if (n.equals("")||p.equals(""))  
    	    	JOptionPane.showMessageDialog(null,"Username or password cannot be empty");	
    	    else{	
    	    	try {
    				Connection con=DriverManager.getConnection(dbURL,userName,userPwd);  
    				Statement s=con.createStatement(); 
    				//ResultSet rs=s.executeQuery("select * from Users where username='"+n+"'");
    				//if(rs.getString("password").equals(p1)){   					
    					  PreparedStatement ps=con.prepareStatement("UPDATE Users set password=? where username=? ");
    					  ps.setString(2, n);
    				      ps.setString(1, p2);   				    
    				      int m=ps.executeUpdate( );
    				      ps.close();
    				      if(m!=0){
    					      //System.out.println("done");
    					      JOptionPane.showMessageDialog(null,"modify password - done");
    				    	  t3.setText(null);
    				    	  t4.setText(null);
    				    	  t5.setText(null);
    				      }   				   
    				      //else 
    					  s.close();
    				      con.close();
    				   }
    	    	//}
    					catch(SQLException e1)
    					   {
    						  JOptionPane.showMessageDialog(null,"username or password is incorrect, and you are not authorized to delete user information!");
    					      System.out.println("SQLException 3: " +e1.getMessage( ));
    					   }
    			} 		 
        }
      }	
     }
   }