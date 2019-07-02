package eventPack;


import algopack.BFSalgo;
import framePack.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javafx.application.*;
import java.lang.String;


import javax.swing.JOptionPane;
public class back implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		
		MainFrame reFrame=MainFrame.getRef();
		reFrame.remove(input_bfs.getRef());
		reFrame.createFrame(HomePanel.getRef());
	}
}