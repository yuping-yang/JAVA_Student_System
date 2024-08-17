package pkg;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
public class dbstu extends JFrame implements ActionListener
{
	JLabel l1=new JLabel("ID");
	JLabel l2=new JLabel("name");
	JLabel l3=new JLabel("gender");
	JLabel l4=new JLabel("literature");
	JLabel l5=new JLabel("math");
	JLabel l6=new JLabel("english");
	JLabel l7=new JLabel("sum");
	JLabel l8=new JLabel("overall");
	JLabel l9=new JLabel("ID	name	gender	sum	literature	math	english	overall");
	JTextField t1=new JTextField(10);
	JTextField t2=new JTextField(10);
	JTextField t3=new JTextField(10);
	JTextField t4=new JTextField(10);
	JTextField t5=new JTextField(10);
	JTextField t6=new JTextField(10);
	JTextField t7=new JTextField(10);
	JTextField t8=new JTextField(10);
	TextArea ta=new TextArea();
	JButton b1=new JButton("add");
	JButton b2=new JButton("delete");
	JButton b3=new JButton("modify");
	JButton b4=new JButton("search by ID");
	JButton b6=new JButton("search by name");
	JButton b5=new JButton("show all");
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel p4=new JPanel();	   
	String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=dbstu";
    String userName="sa"; 
    String userPwd="sunshinehvd"; 
	public int i=5;
        
      public dbstu(int i)
	{
    	  this.i=i;
		//setLayout(new GridLayout(5,1));
    	  setLayout(null);   
    		  if(i==5){
    		    setTitle("statistics of scores");
    		    p4.add(b5);
    		    l9.setBounds(new Rectangle(0,0,600,40));
    		    l9.setBackground(Color.white);
    		    l9.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white));
    		    ta.setBounds(new Rectangle(0,40,580,320));

    	  }
    		  
    	  else {
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(l3);
	    p1.add(t3);
		p2.add(l4);
		p2.add(t4);
		p2.add(l5);
		p2.add(t5);
		p2.add(l6);
		p2.add(t6);
		p3.add(l7);
		p3.add(t7);
		p3.add(l8);
		p3.add(t8);
           if(i==1)
           {  setTitle("insert");
   	    p4.add(b1);}
           if(i==2)
           {  setTitle("delete");
   	    p4.add(b2);}
           if(i==3)
           {  setTitle("modify");
	    p4.add(b3);}
           if(i==4)
           {  setTitle("search by ID");
   	    p4.add(b4);}           
           if(i==6)
           {  setTitle("search by name");
   	    p4.add(b6);}
	
	    p1.setBounds(new Rectangle(0,0,600,40));
	    p1.setBackground(Color.white);
	    p1.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white));
	    p2.setBounds(new Rectangle(0,40,600,40));
	    p2.setBackground(Color.white);
	    p2.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white));
	    p3.setBounds(new Rectangle(0,80,600,40));
	    p3.setBackground(Color.white);
	    p3.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white));
	    l9.setBounds(new Rectangle(0,120,600,40));
	    l9.setBackground(Color.white);
	    l9.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white));
	    ta.setBounds(new Rectangle(0,160,580,200));
     }  
	    ta.setBackground(Color.white);
	    
	    p4.setBounds(new Rectangle(0,360,600,100));
	    p4.setBackground(Color.white);
	    p4.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white));
	    add(p1);
	    add(p2);
	    add(p3);
	    add(l9);
		add(ta);
		add(p4);
	    b1.addActionListener(this);
	    b2.addActionListener(this);
	    b3.addActionListener(this);
	    b4.addActionListener(this);
	    b5.addActionListener(this);
	    b6.addActionListener(this);
	    setSize(600, 440);  
	    setLocation(400,180);
	    setVisible(true);
	    this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();	}
		}); 
	}
		  
	 public void actionPerformed(ActionEvent e){
		 if(e.getSource()==b1)
		 {
			    String num=t1.getText();
				String nam=t2.getText();
				String sex=t3.getText();
				String chi=t4.getText();
				String mat=t5.getText();
				String eng=t6.getText();
				String sco=Integer.toString(Integer.parseInt(chi)+Integer.parseInt(mat)+Integer.parseInt(eng));
				String gra=t8.getText();
				try {
				  Connection con=DriverManager.getConnection(dbURL,userName,userPwd);  
				  Statement s=con.createStatement();  
				  PreparedStatement ps=con.prepareStatement("insert into Stu values(?,?,?,?,?,?,?,?)");
			      ps.setString(1, num);
			      ps.setString(2, nam);
			      ps.setString(3, sex);
			      ps.setString(4, sco);
			      ps.setString(5, chi);
			      ps.setString(6, mat);
			      ps.setString(7, eng);		      
			      ps.setString(8, gra);
			      int m= ps.executeUpdate( ); 
			      if(m!=0){
			    	  //System.out.println("done");
			    	  JOptionPane.showMessageDialog(null,"done");
			    	  t1.setText(null);
			    	  t2.setText(null);
			    	  t3.setText(null);
			    	  t4.setText(null);
			    	  t5.setText(null);
			    	  t6.setText(null);
			    	  t7.setText(null);
			    	  t8.setText(null);
			    	  ta.setText(null);
			    	  ResultSet rs=s.executeQuery("select * from stu");    
				      while(rs.next( ))
				       { 
				    	  ta.append(rs.getString("ID")+"\t"+rs.getString("name")+"\t"+rs.getString("gender")+"\t"+rs.getString("sum")+"\t"+rs.getString("literature")+"\t"+rs.getString("math")+"\t"+rs.getString("english")+"\t"+rs.getString("overall")+"\n");
				       }
				      ///////..................................................................
			      }
				  s.close(); 
			      con.close();  
				}
				catch(SQLException e1) 
			     { System.out.println("SQLException 1: " +e1.getMessage());  }
		 }
		 if(e.getSource()==b2){ 
				String num=t1.getText();
				try {
					Connection con=DriverManager.getConnection(dbURL,userName,userPwd);  
					  Statement s=con.createStatement();  
					  PreparedStatement ps=con.prepareStatement("delete from Stu where ID=?");
				      ps.setString(1,num);
				      int m=ps.executeUpdate( ); 
				      if(m!=0){
				    	//System.out.println("done");
				    	JOptionPane.showMessageDialog(null,"done");
				    	t1.setText(null);
				    	ta.setText(null);
				    	
				     	ResultSet rs=s.executeQuery("select * from stu");    
				     	while(rs.next( ))
				     	{ 
				     		ta.append(rs.getString("ID")+"\t"+rs.getString("name")+"\t"+rs.getString("gender")+"\t"+rs.getString("sum")+"\t"+rs.getString("literature")+"\t"+rs.getString("math")+"\t"+rs.getString("english")+"\t"+rs.getString("overall")+"\n");
				     	}
				      }
				      s.close();  
				      con.close();  
				}
				catch(SQLException e1)
				   {
				      System.out.println("SQLException 2: " +e1.getMessage( ));
				    }
	 }
		 if(e.getSource()==b3){
			    String num=t1.getText();
				String nam=t2.getText();
				String sex=t3.getText();
				String chi=t4.getText();
				String mat=t5.getText();
				String eng=t6.getText();;
				String sco=Integer.toString(Integer.parseInt(chi)+Integer.parseInt(mat)+Integer.parseInt(eng));
				String gra=t8.getText();
				try {
					Connection con=DriverManager.getConnection(dbURL,userName,userPwd); 
				  Statement s=con.createStatement(); 
				  PreparedStatement ps=con.prepareStatement("UPDATE Stu set name=?,gender=?,sum=?,literature=?,math=?,english=?,overall=? where ID=? ");
				  ps.setString(8, num);
			      ps.setString(1, nam);
			      ps.setString(2, sex);
			      ps.setString(3, sco);
			      ps.setString(4, chi);
			      ps.setString(5, mat);
			      ps.setString(6, eng);	     
			      ps.setString(7, gra);
			      int m=ps.executeUpdate( );
			      ps.close();
			      if(m!=0){
				      //System.out.println("done");
				      JOptionPane.showMessageDialog(null,"done");
				      t1.setText(null);
			    	  t2.setText(null);
			    	  t3.setText(null);
			    	  t4.setText(null);
			    	  t5.setText(null);
			    	  t6.setText(null);
			    	  t7.setText(null);
			    	  t8.setText(null);
			    	  ta.setText(null);
				      ResultSet rs=s.executeQuery("select * from stu"); 
				      while(rs.next( ))
				       { 
				    	  ta.append(rs.getString("ID")+"\t"+rs.getString("name")+"\t"+rs.getString("gender")+"\t"+rs.getString("sum")+"\t"+rs.getString("literature")+"\t"+rs.getString("math")+"\t"+rs.getString("english")+"\t"+rs.getString("overall")+"\n");
				       }
				      ///////..................................................................
			      }
				  s.close(); 
			      con.close(); 
				}
				catch(SQLException e1)
				   {
				      System.out.println("SQLException 3: " +e1.getMessage( ));
				    }
		 }
		 if(e.getSource()==b4){
				String num=t1.getText();
				try {
					Connection con=DriverManager.getConnection(dbURL,userName,userPwd);
					Statement s=con.createStatement( );
				    ResultSet rs=s.executeQuery("select * from Stu where ID='"+num+"'");  
				    t1.setText(null);
				    ta.setText(null);
				      if(rs.next( ))
				       { 
				    	  ta.append(rs.getString("ID")+"\t"+rs.getString("name")+"\t"+rs.getString("gender")+"\t"+rs.getString("sum")+"\t"+rs.getString("literature")+"\t"+rs.getString("math")+"\t"+rs.getString("english")+"\t"+rs.getString("overall")+"\n");
				    	  }
				      else JOptionPane.showMessageDialog(null,"no info");
				      s.close( );
				      con.close( );
				}
				    catch(SQLException e1)
				   {
				      System.out.println("SQLException 4: " +e1.getMessage( ));
				    }
			}
		 if(e.getSource()==b6){
				String nam=t2.getText();
				try {
					Connection con=DriverManager.getConnection(dbURL,userName,userPwd); 
					Statement s=con.createStatement( );
				    ResultSet rs=s.executeQuery("select * from Stu where name='"+nam+"'");  
				    t1.setText(null);
				    ta.setText(null);
				      if(rs.next( ))
				       { 
				    	  ta.append(rs.getString("ID")+"\t"+rs.getString("name")+"\t"+rs.getString("gender")+"\t"+rs.getString("sum")+"\t"+rs.getString("literature")+"\t"+rs.getString("math")+"\t"+rs.getString("english")+"\t"+rs.getString("overall")+"\n");
				    	  }
				      else JOptionPane.showMessageDialog(null,"no info");
				      s.close( );
				      con.close( );
				}
				    catch(SQLException e1)
				   {
				      System.out.println("SQLException 4: " +e1.getMessage( ));
				    }
			}
		 if(e.getSource()==b5){
				try {
					Connection con=DriverManager.getConnection(dbURL,userName,userPwd); 
					Statement s=con.createStatement( );
					ResultSet rs=s.executeQuery("select * from Stu"); 
					ta.setText(null);
					while(rs.next( ))
				       { 
						ta.append(rs.getString("ID")+"\t"+rs.getString("name")+"\t"+rs.getString("gender")+"\t"+rs.getString("sum")+"\t"+rs.getString("literature")+"\t"+rs.getString("math")+"\t"+rs.getString("english")+"\t"+rs.getString("overall")+"\n");
				       }
				      s.close( );
				      con.close( );
			}catch(SQLException e1)
				   {
			      System.out.println("SQLException 5: " +e1.getMessage( ));
			    }
			}	 
	 }


	public static void main(String args[]){
		//new SplashWindow();
		new dbstu(5);
	}
}
