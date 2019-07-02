package framePack;

import eventPack.LoginEvent;
import eventPack.registerEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;


public class LoginPanel extends JPanel {
	private static boolean create=false;
	private static LoginPanel loginRef=null;
	
	private static JPasswordField pass=null;
	private static JTextField text1=null;
	
	public static LoginPanel getRef() {
		if(create==false) {
			loginRef=new LoginPanel();
			create=true;
			return loginRef;
		}else return loginRef;
	}
	private LoginPanel() {
		this.loginRef=this;
		this.setLayout(null);
		this.setName("Login Window");
		this.setSize(400,500);
		this.setLocation(250,80);
		
		
		initialize();
		
		this.setVisible(true);
	}
	private void initialize() {
		JLabel labeluser = new JLabel("User Name: ");
		labeluser.setBounds(35, 80, 80, 25);
		add(labeluser);
		
		text1 = new JTextField();
		text1.setBounds(128, 77, 220, 30);
		text1.setText("");
		add(text1);
		
		JLabel labelPassword = new JLabel("Password: ");
		labelPassword.setBounds(35, 163, 80, 25);
		add(labelPassword);
		
		pass = new JPasswordField();
		pass.setBounds(128, 160, 220, 30);
		add(pass);
		
		//Login_Button
		JButton login = new JButton("Login");
		login.setBounds(35, 250, 100, 35);
		add(login);
		login.addActionListener(new LoginEvent());
		
		//Register_Button
		JButton register = new JButton("Register");
		register.setBounds(250, 250,100, 35);
		add(register);
		register.addActionListener(new registerEvent());
		
		
		
		
	}
	public static String getUserName() {
		return text1.getText();
	}
	public static char[] getPasss() {
		return pass.getPassword();
	}	
}
