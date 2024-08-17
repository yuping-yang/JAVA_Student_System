package pkg;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;
public class SplashWindow extends JWindow implements ActionListener{
    JLabel back = new JLabel(new ImageIcon("e://picture/school.jpg"));
    JProgressBar progressBar = new JProgressBar(1,100);
    Timer timer;
    String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=dbstu";
    String userName="sa";
    String userPwd="sunshinehvd";
    public SplashWindow(){
    	  Container con = this.getContentPane();
    	  setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
          progressBar.setStringPainted(true);
    	  progressBar.setString("loading...");   	
    	  con.add(back,"Center");
    	  con.add(progressBar,"South");
    	  setSize(400,300);
          toFront();
    	  Dimension size = Toolkit.getDefaultToolkit().getScreenSize();    setLocation((size.width-getWidth())/2,(size.height-getHeight())/2);
    	  setVisible(true);
          timer = new javax.swing.Timer(100,this);
          timer.addActionListener(this);
    	  timer.start();
    	  
    	  Connection conn=null;  
  	    try{	
       	   Class.forName(driverName);	
          System.out.println("done");
          } catch(Exception e)
          {	e.printStackTrace();	
          System.out.println("error");
          }           
          try{
             Class.forName(driverName); 
             Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd); 
             System.out.println("connected"); 
          }catch(Exception e){
             System.out.println("disconnected");
        }
  	}
    
    public void actionPerformed(ActionEvent e){
    	if(progressBar.getValue()<100){
    		progressBar.setValue(progressBar.getValue()+1);
    		timer.restart();
    	}else{
    		timer.stop();
    		dispose();
    		new Password();

    	}
    }
    public static void main(String[] args) {
		new SplashWindow();
	}
}
