package pkg;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
public class Password implements ActionListener{
   JFrame jf= new JFrame("student system");
   JTextField user;
   JPasswordField passwd;
   JButton b1,b2;
   Container cont;
   JDialog dl;
   int i=0;
   int s=0;
   static String names[]=new String[10];
   static String passwords[]=new String[15];
   String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
   String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=dbstu";
   String userName="sa";  
   String userPwd="sunshinehvd";  
   public Password(){
	   names[7]="Will";
	   passwords[7]="201501";
	   names[8]="a";
	   passwords[8]="a";
	   names[5]="b";
	   passwords[5]="b";
	   names[6]="c";
	   passwords[6]="c";
	   names[9]="Bob";
	   passwords[9]="201502";
	   dl=new JDialog();
	   dl.setTitle("please input username and password");
	   cont=dl.getContentPane();
	   cont.setLayout(new  GridLayout(3,2));
	   cont.add(new JLabel("username",SwingConstants.CENTER));
	   user=new JTextField();
	   cont.add(user);	   
	   cont.add(new JLabel("password",SwingConstants.CENTER));
	   passwd=new JPasswordField();
	   cont.add(passwd);
	   b1=new JButton("confirm");
	   b2=new JButton("exit");	   
	   cont.add(b1);	   
	   cont.add(b2);
	   b1.addActionListener(this);
	   b2.addActionListener(this);	   
	   dl.setBounds(500,300,400,150);
	   dl.getRootPane().setDefaultButton(b1);
	   dl.setVisible(true);	  
	   
	   
        try {
			Connection con=DriverManager.getConnection(dbURL,userName,userPwd); 
			Statement s=con.createStatement( );
			ResultSet rs=s.executeQuery("select * from Users"); 
			ArrayList<String> list1=new ArrayList<String>();
			ArrayList<String> list2=new ArrayList<String>();
			while (rs.next()) {
			    list1.add(rs.getString(1)); 
			    list2.add(rs.getString(2));
			   }  
			   if(list1 != null && list1.size()>0){
			      
			    for(int i=0;i<list1.size();i++){  
			    names[i]=list1.get(i);
			    } 
			   }
			    if(list2 != null && list2.size()>0){ 
				      
				    for(int i=0;i<list2.size();i++){  
				    passwords[i]=list2.get(i);
				    } 
		      s.close( );
		      con.close( );
	          }
        }
			    catch(SQLException e1)
		   {
	      System.out.println("SQLException 5: " +e1.getMessage( ));
	    }

	   
   }
	  
   public void actionPerformed(ActionEvent e){
		   String command =e.getActionCommand();
		   if(command.equals("confirm")){
			   String name=user.getText();
			   char[] num=passwd.getPassword();
			   String password = new String (num);	

	if(i<3){
			for(int j=0;j<10;j++)
			{
			   if((name.equals(names[j]))&&(password.equals(passwords[j])))
			   {
				   s=1;
				   dl.dispose();
				   new Interface();
				   break;
			   }
			}
			if(s==0)
				{
				   i++;  
				   //System.out.println(i);
				   //System.out.println("s"+s);
				   //System.out.println("sss"+names[0]+passwords[0]);
				   JOptionPane.showMessageDialog(dl,"incorrect username or password",null,JOptionPane.WARNING_MESSAGE);
				   user.setText("");
				   passwd.setText("");
			   }
		}
	else {
		 JOptionPane.showMessageDialog(dl,"the number of incorrect input has exceeded 3 the system will be exited!",!",null,JOptionPane.WARNING_MESSAGE);
		 System.exit(0);					  
		 }
	}		   
	if (command.equals("exit")){
		System.exit(0);
		}   	   
	   }
	  public static void main(String args[]){
		  new SplashWindow();
	  }
}
	