package eventPack;

import framePack.HomePanel;

import framePack.LoginPanel;
import framePack.MainFrame;
import framePack.RegisterPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import javax.swing.*;


public class LoginEvent implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.printf("Login Button Click!");
		if(LoginPanel.getUserName().equals("") || LoginPanel.getPasss()==null) {
			JOptionPane.showMessageDialog(null, "Fill Up Correctly!!!!!!!", "Error", JOptionPane.ERROR_MESSAGE);
			//return;
		}/*else if(LoginPanel.getUserName().length()>=1)
		{
			JOptionPane.showMessageDialog(null, "Fill Up Correctly!!!!!!!", "Error", JOptionPane.ERROR_MESSAGE);
		}*/
		else
		
		{
			String url = "jdbc:mysql://localhost:3306/account";
			String user = "root";
			String password = "";
			String name = LoginPanel.getUserName();
			char[] passs = LoginPanel.getPasss();
			String p = new String (passs);
			
			
			
			try {
				Connection myconn = DriverManager.getConnection(url, user, password);
				Statement myst = myconn.createStatement();
				ResultSet rs;
				String sql2 = "SELECT usr, pass FROM information WHERE usr = '"+name+"'and pass= '"+p+"'";
				//String sql2 = "SELECT usr FROM information WHERE usr = '"+name;
				rs = myst.executeQuery(sql2);
				int count=0;
				while(rs.next())
				{
					count = count+1;
				}
				if(count==1)
				{
					MainFrame reFrame=MainFrame.getRef();
					reFrame.remove(LoginPanel.getRef());
					reFrame.createFrame(HomePanel.getRef());
				}
				else
				{
					JOptionPane.showMessageDialog(null, "User Not Found!!!!!!!!", "Error", JOptionPane.ERROR_MESSAGE);	
				}				
			}
			catch(Exception exc) {
				
				exc.printStackTrace();
			}

			/*MainFrame reFrame=MainFrame.getRef();
			reFrame.remove(LoginPanel.getRef());
			reFrame.createFrame(HomePanel.getRef());*/
			
		}
	}
}
