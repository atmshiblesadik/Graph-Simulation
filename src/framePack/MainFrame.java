package framePack;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame {
	private static boolean create=false;
	public static MainFrame frameRef;
	public static MainFrame getRef() {
		if(create==false) {
			frameRef=new MainFrame();
			create=true;
			return frameRef;
		}else return frameRef;
	}
	private MainFrame() {
		frameRef=this;
		createFrame(LoginPanel.getRef());
	}
	public void createFrame(JPanel panel) {
		this.setTitle(panel.getName());
		this.add(panel);
		this.setLocation(panel.getLocation());
		this.setSize(panel.getSize());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.repaint();
		this.setVisible(true);
	}
	
}
