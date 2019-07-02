package eventPack;

import framePack.HomePanel;
import framePack.LoginPanel;
import framePack.RegisterPanel;
import framePack.input_bfs;
import framePack.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
public class algoevent implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
			MainFrame reFrame=MainFrame.getRef();
			reFrame.remove(HomePanel.getRef());
			reFrame.createFrame(input_bfs.getRef());
		
	}
}
