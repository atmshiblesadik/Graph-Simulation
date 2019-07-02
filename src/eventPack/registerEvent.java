package eventPack;

import framePack.HomePanel;
import framePack.LoginPanel;
import framePack.RegisterPanel;
import framePack.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
public class registerEvent implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
			MainFrame reFrame=MainFrame.getRef();
			reFrame.remove(LoginPanel.getRef());
			reFrame.createFrame(RegisterPanel.getRef());
		
	}
}