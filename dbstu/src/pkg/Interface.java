package pkg;
import javax.swing.*;  
import javax.swing.event.DocumentEvent;  
import javax.swing.event.DocumentListener;  

import java.awt.*;  
import java.io.*;  
import java.awt.event.*;  

public class Interface extends JFrame implements ActionListener {   
    JMenuBar menubar=new JMenuBar();  
    JMenu manage=new JMenu("organise");  
    JMenu check=new JMenu("view");  
    JMenu search=new JMenu("search");   
    JMenu user =new JMenu("setting");  
    JMenu tip =new JMenu("help");
    String [] str1={"add","delete","modify"}; 
    String [] str2={"all","specific","sum","overall"};  
    String [] str3={"search by ID","search by name"};
    String [] str4={"add account","delete account","modify account","exit"};
    JMenuItem jmi=new JMenuItem("intro");
    JLabel back = new JLabel(new ImageIcon("e://picture/0001.jpg"));
    Tip t=new Tip();
    int flag=0; 
    String source="";
	public String name2;
	public int style2;
	public int size2;
	public int s=0;
    public String gd="";
    public String gf="";
    public static void main(String[] args) {  
      JFrame Interface=new Interface();  
    }  
    public Interface(){  
       setTitle("student grades database");  
       Toolkit kit = Toolkit.getDefaultToolkit(); 
       Dimension screenSize = kit.getScreenSize();
       setSize(screenSize.width/2,screenSize.height/2);
       setLocation(screenSize.width/4,screenSize.height/4);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setJMenuBar(menubar);    
       menubar.add(manage);  
       menubar.add(check);  
       menubar.add(search);    
       menubar.add(user); 
       menubar.add(tip); 
       setVisible(true);
       Container con = this.getContentPane();
       con.add(back,"Center");
       /* addWindowListener(new WindowAdapter() {
    	  public void windowClosing(java.awt.event.WindowEvent e) {
    	   exit();
    	   }
    	   });*/
       jmi.addActionListener(new MyActionListener1());
       tip.add(jmi);
          
       for(int i=0;i<str1.length;i++){ 
          JMenuItem item1= new JMenuItem(str1[i]);  
          item1.addActionListener(new MyActionListener1());   
          manage.add(item1);  
       }  
       for(int i=0;i<str2.length;i++){ 
          JMenuItem item2= new JMenuItem(str2[i]);  
          item2.addActionListener(new MyActionListener1());   
          check.add(item2);  
       }  
       for(int i=0;i<str3.length;i++){ 
           JMenuItem item3= new JMenuItem(str3[i]);  
           item3.addActionListener(new MyActionListener1());   
           search.add(item3);  
        } 
       for(int i=0;i<str4.length;i++){ 
           JMenuItem item4= new JMenuItem(str4[i]);  
           item4.addActionListener(new MyActionListener1());   
           user.add(item4);  
        } 
    }
	class MyActionListener1 implements ActionListener{  
        public void actionPerformed(ActionEvent e) {  
            if(e.getSource()instanceof JMenuItem){  
                if(e.getActionCommand()=="add"){  
                     new dbstu(1);
                }  
                if(e.getActionCommand()=="delete"){  
                	 new dbstu(2);
                }  
                if(e.getActionCommand()=="modify"){  
                	 new dbstu(3);
                }  
                if(e.getActionCommand()=="all"){  
                	 new dbstu(5);
                }
                if(e.getActionCommand()=="specific"){  
                	new single(7);
                }  
                if(e.getActionCommand()=="sum"){  
                	new scores(8);
                }  
                if(e.getActionCommand()=="overall"){  
                	new grades(9);
                }  
                if(e.getActionCommand()=="search by ID"){  
                	 new dbstu(4);
                }
                if(e.getActionCommand()=="search by name"){  
                	 new dbstu(6);          	
                }  
                if(e.getActionCommand()=="add account"){  
                     new users(1);
                }  
                if(e.getActionCommand()=="delete account"){  
                	 new users(2);
                } 
                if(e.getActionCommand()=="modify account"){  
                	 new users(3);
                }  
                if(e.getActionCommand()=="exit"){  
                	System.exit(0);
                }  
                if(e.getActionCommand()=="intro"){  
                	t.setVisible(true); 
                }  
            }  
        }}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}}