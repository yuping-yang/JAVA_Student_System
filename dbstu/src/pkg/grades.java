package pkg;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
public class grades extends JFrame{
String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=dbstu";
String userName="sa"; 
String userPwd="sunshinehvd"; 
JLabel l1=new JLabel("ID	name	gender	overall");
TextArea t1=new TextArea();
JButton b=new JButton("search");

JPanel p=new JPanel();
public int i=5;
 public grades(int i){
	 this.i=i;
   if(i==9){
	   setLayout(null); 
	  b.addActionListener(new MyActionListener1());
      l1.setBounds(new Rectangle(50,0,600,30));
	  l1.setBackground(Color.white);
	  l1.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white));
	  t1.setBackground(Color.white);
	  t1.setBounds(new Rectangle(50,30,380,170));
	  p.setBounds(new Rectangle(400,-4,60,31));
	  p.setBackground(Color.white);
	  p.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white));

	    JScrollPane jsp1 = new JScrollPane(t1);
	    add(jsp1);

	  add(l1);
	  add(t1);

	  p.add(b,BorderLayout.EAST);
	  add(p);
	  setTitle("search by overall");
	  setSize(490, 250);  
	  setLocation(600,100);
	  setVisible(true);
	  this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();	}
		});  
}
}
class MyActionListener1 implements ActionListener{
   public void actionPerformed(ActionEvent e){
      if (e.getSource()==b){
	 try {
			Connection con=DriverManager.getConnection(dbURL,userName,userPwd); 
			Statement s=con.createStatement( );
			ResultSet rs=s.executeQuery("select * from Stu"); 
			t1.setText(null);
			while(rs.next( ))
		       { 
				t1.append(rs.getString("ID")+"\t"+rs.getString("name")+"\t"+rs.getString("gender")+"\t"+rs.getString("overall")+"\n");
				
		       }
		      s.close( );
		      con.close( );
	}catch(SQLException e1)
		   {
	      System.out.println("SQLException 5: " +e1.getMessage( ));
	    }
		
      }
    }
  }
}