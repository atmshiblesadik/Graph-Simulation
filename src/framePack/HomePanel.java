package framePack;

import algopack.BFSalgo;
import eventPack.LoginEvent;
import eventPack.algo_dfs;
import eventPack.algoevent;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class HomePanel extends JPanel {
	private static boolean create=false;
	private static HomePanel homeRef=null;
	
	
	public static HomePanel getRef() {
		if(create==false) {
			homeRef=new HomePanel();
			create=true;
			return homeRef;
		}else return homeRef;
	}
	private HomePanel() {
		this.homeRef=this;
		this.setLayout(null);
		this.setName(LoginPanel.getUserName()+" "+"Home Panel");
		this.setSize(800,600);
		this.setLocation(200,80);
		
		initialize();
		
		this.setVisible(true);
	}
	private void initialize() {
		JLabel welcome = new JLabel("Welcome"+" "+LoginPanel.getUserName());
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setFont(new Font(null, Font.PLAIN, 48));
		welcome.setBounds(10, 40, 780, 50);
		add(welcome);
		
	//BFS
		JButton bfs = new JButton("BFS");
		bfs.setBounds(60,120,100,35);
		add(bfs);	
		bfs.addActionListener(new algoevent());		
		//DFS
		JButton dfs = new JButton("DFS");
		dfs.setBounds(60,160,100,35);
		add(dfs);	
		dfs.addActionListener(new algo_dfs());		
		
	}

}
