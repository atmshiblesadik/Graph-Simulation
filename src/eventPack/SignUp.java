package eventPack;

import framePack.HomePanel;
import framePack.LoginPanel;
import framePack.MainFrame;
import framePack.RegisterPanel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

import javax.swing.*;
import javax.swing.JOptionPane;

import java.sql.*;
import javax.swing.ImageIcon;


public class SignUp implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.printf("Login Button Click!");
		if(RegisterPanel.getUserName().equals("") || RegisterPanel.getPass().equals("")|| RegisterPanel.getRepass().equals("") || RegisterPanel.getEmail().equals("") || RegisterPanel.getContact().equals("")) {
			JOptionPane.showMessageDialog(null, "Please fill up form correctly", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}else {
			/*MainFrame reFrame=MainFrame.getRef();
			reFrame.remove(LoginPanel.getRef());
			reFrame.createFrame(HomePanel.getRef());
			*/
			String url = "jdbc:mysql://localhost:3306/account";
			String user = "root";
			String password = "";
			String name = RegisterPanel.getUserName();
			String pass = RegisterPanel.getPass();
			String repass = RegisterPanel.getRepass();
			String contact = RegisterPanel.getContact();
			String email = RegisterPanel.getEmail();
			
			try {
				Connection myconn = DriverManager.getConnection(url, user, password);
				Statement myst = myconn.createStatement();
				String sql = "INSERT INTO information(usr, pass, repass, email, contact)VALUES(?,?,?,?,?)";
				        PreparedStatement statement = myconn.prepareStatement(sql);
				        statement.setString(1,name);
				        statement.setString(2,String.valueOf(pass));
				        statement.setString(3, String.valueOf(repass));
				        statement.setString(4, email);
				        statement.setString(5, contact);
				        statement.executeUpdate();
				System.out.println("Inserted");
			}
			catch(Exception exc) {
				
				exc.printStackTrace();
			}
			
			ImageIcon image = new ImageIcon("tick.png");
			JOptionPane.showMessageDialog(null, "Registration Sucessful", "Sucess", JOptionPane.INFORMATION_MESSAGE,image);
			MainFrame reFrame=MainFrame.getRef();
			//reFrame.remove(LoginPanel.getRef());
			//reFrame.createFrame(RegisterPanel.getRef());
			reFrame.remove(RegisterPanel.getRef());
			reFrame.createFrame(LoginPanel.getRef());
			
		}
	}
}
