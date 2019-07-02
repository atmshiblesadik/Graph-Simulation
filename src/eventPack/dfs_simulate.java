package eventPack;


import algopack.DFSalgo;
import framePack.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
public class dfs_simulate implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("\naction in dfs");
		int start_node=input_dfs.start_node();
		DFSalgo game=new DFSalgo();
		game.dfs(start_node);
        
		JFrame win=new JFrame(" DFS Simulation ");
        win.add(game);
		win.setSize(800,600);
        win.setLocationRelativeTo(null);
        win.setVisible(true);
        win.repaint();
		///game.animation();
	}
}