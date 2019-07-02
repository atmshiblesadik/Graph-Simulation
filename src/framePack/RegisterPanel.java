package framePack;

import eventPack.LoginEvent;
import eventPack.registerEvent;
import eventPack.SignUp;

/*import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;*/
import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;
/*
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingConstants;
import javax.swing.UIManager;*/


public class RegisterPanel extends JPanel {
	private static boolean create=false;
	private static RegisterPanel registerref=null;
	
	private static JPasswordField pass=null;
	private static JTextField text1=null;
	
	private static JPasswordField repass=null;
	private static JTextField text2=null;
	private static JTextField text3=null;
	private static JTextField text4=null;
	private static JTextField text5=null;
	private static JTextField text6=null;

	//Form starts here;

	public static RegisterPanel getRef() {
		if(create==false) {
			registerref=new RegisterPanel();
			create=true;
			return registerref;
		}else return registerref;
	}
	private RegisterPanel() {
		this.registerref=this;
		this.setLayout(null);
		this.setName("Register Panel");
		this.setSize(600,600);
		this.setLocation(200,80);
		
		initialize();
		
		
		this.setVisible(true);
		this.setVisible(true);
	}
	private void initialize() {
		JLabel welcome = new JLabel("Welcome new User");
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setFont(new Font(null, Font.PLAIN, 36));
		welcome.setBounds(60, 40, 570, 50);
		JLabel image = new JLabel();
		image.setBounds(60,20,100,100);
		image.setIcon(new ImageIcon("user.png"));
		add(image);
		
		validate();
		
		//add(img);
		
		add(image);
		add(welcome);
//		JLabel picLabel = new JLabel(new ImageIcon("men.png"));
		//add(picLabel);



		
		initialize2();
		
		//Form component initialize;
		
	}
	private void initialize2(){
		//UserName
		JLabel labeluser = new JLabel("Enter User Name: ");
		labeluser.setBounds(60, 120, 120, 25);
		add(labeluser);
		text1 = new JTextField();
		text1.setBounds(220, 117, 220, 30);
		text1.setText("");
		add(text1);      
		
		//Password
		JLabel labelPass = new JLabel("Enter Password:");
		labelPass.setBounds(60,160,120,25);
		add(labelPass);
		pass = new JPasswordField();
		pass.setBounds(220,160,220,30);
		add(pass);
		
		//RePass
		JLabel labelrepass = new JLabel("Re Enter Password:");
		labelrepass.setBounds(60,200,120,25);
		add(labelrepass);
		repass = new JPasswordField();
		repass.setBounds(220,200,220,30);
		add(repass);
		
		//Email
		JLabel labelemail = new JLabel("Enter Email:");
		labelemail.setBounds(60,240,120,25);
		add(labelemail);
		text2 = new JTextField();
		text2.setBounds(220,240,220,30);
		text2.setText("");
		add(text2);
		
		//Contact
		JLabel labelphone = new JLabel("Enter phone:");
		labelphone.setBounds(60,280,120,25);
		add(labelphone);
		text3 = new JTextField();
		text3.setBounds(220,280,220,30);
		text3.setText("");
		add(text3);	
		
		//SignUP_Button
		
		JButton signup = new JButton("Sign Up");
		signup.setBounds(250, 400,100, 35);
		add(signup);
		signup.addActionListener(new SignUp());
	}
	//return user_name
	public static String getUserName() {
		return text1.getText();
	}	
	
    //return password
	public static String getPass() {
		return pass.getText();
	}	
	//return repassword
	public static String getRepass() {
		return repass.getText();
	}	
	//return email
	public static String getEmail() {
		return text2.getText();
	}	
	//return contact
	public static String getContact() {
		return text3.getText();
	}	
	

}
