package eventPack;


import algopack.BFSalgo;
import framePack.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
public class bfs_simulate implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int start_node = input_bfs.start_node();
		BFSalgo game=new BFSalgo();
		game.bfs(start_node);
        
		JFrame win=new JFrame(" BFS Simulation ");
        win.add(game);
		win.setSize(800,600);
        win.setLocationRelativeTo(null);
        win.setVisible(true);
		game.animation();
	}
}