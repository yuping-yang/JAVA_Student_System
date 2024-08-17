package pkg;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
public class Tip extends JFrame  {
	JLabel label;
	Container contentPane;
	public Tip(){
		setSize(470,310);	
		setTitle("intro");
		Toolkit kit = Toolkit.getDefaultToolkit(); 
	    Dimension screenSize = kit.getScreenSize();
	    setLocation(screenSize.width/3,screenSize.height/4);
	this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	contentPane = getContentPane();
	contentPane.setLayout(new GridLayout(1,1));
	label=new JLabel();
	label.setVisible(true);
	label.setIcon(new ImageIcon("e:/java/1223text/tips.jpg/"));
	contentPane.add(label);	
	}
	public static void main(String[] args) {
		new Tip();
	}
}

 