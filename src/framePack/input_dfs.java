package framePack;



import eventPack.LoginEvent;
import eventPack.registerEvent;
import eventPack.SignUp;
import eventPack.algoevent;
import eventPack.back;
import eventPack.back_dfs;

import eventPack.dfs_simulate;

/*import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;*/
import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;
/*
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingConstants;
import javax.swing.UIManager;*/


public class input_dfs extends JPanel{
	private static boolean create=false;
	private static input_dfs registerref=null;
	
	
	private static JTextField text1=null;
	
	
	private static JTextField text2=null;
	private static JTextField text3=null;
	private static JTextField text4=null;
	private static JTextField text5=null;
	private static JTextField text6=null;
	int x,y;
	//int[] y = new int[10];
	public static int[][] graph = new int[10][10]; 
	
	static int i = 0, j = 0;	
	static int edge = 0;

	//Form starts here;

	public static input_dfs getRef() {
		if(create==false) {
			registerref=new input_dfs();
			create=true;
			return registerref;
		}else return registerref;
	}
	private input_dfs() {
		this.registerref=this;
		this.setLayout(null);
		this.setName("Input Panel DFS");
		this.setSize(600,600);
		this.setLocation(200,80);
		
		initialize();
		
		
		this.setVisible(true);
		this.setVisible(true);
	}
	private void initialize() {
		JLabel welcome = new JLabel("Please give input for DFS");
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setFont(new Font(null, Font.PLAIN, 36));
		welcome.setBounds(60, 40, 570, 50);
		add(welcome);
//		JLabel picLabel = new JLabel(new ImageIcon("men.png"));
		//add(picLabel);



		
		initialize2();
		
		//Form component initialize;
		
	}
	private void initialize2(){
		//vertices
		JLabel vertices = new JLabel("Enter vertices no: ");
		vertices.setBounds(60, 120, 120, 25);
		add(vertices);
		text1 = new JTextField();
		text1.setBounds(220, 117, 220, 30);
		text1.setText("");
		add(text1);      
		
		//start_node
		JLabel node = new JLabel("Start Node:");
		node.setBounds(60,160,120,25);
		add(node);
		text4 = new JTextField();
		text4.setBounds(220,160,220,30);
		add(text4);
		
		//caution 
		JLabel caution = new JLabel("Click ADD button according number of edges:");
		caution.setBounds(200,200,280,40);
		add(caution);
		
		//input x, y;
		JButton add = new JButton("ADD");
		add.setBounds(220,240,220,30);
		add(add);
		add.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  String str1 = JOptionPane.showInputDialog("Enter X Number");
			    String str2 = JOptionPane.showInputDialog("Enter Y Number");
			    x = Integer.parseInt(str1);
			    y = Integer.parseInt(str2);
			    graph[x][y]=1;
			    edge++;
			    
			  
		  }
		});
		
		
		

		
		/*//start node
		JLabel st_node = new JLabel("Start node:");
		st_node.setBounds(60,200,120,25);
		add(st_node);
		text5 = new JPasswordField();
		text5.setBounds(220,200,220,30);
		add(text5);
		
		//combo_box combo_box
		JLabel nodes = new JLabel("Select node");
		nodes.setBounds(60,240,120,25);
		add(nodes);
		Integer[] nodelist = new Integer[9]; //currentYear is an int variable
		int inc=0;
		for(int i=0;i<9;i++){
			nodelist[i]= inc;
		    inc++;
		}
		JComboBox<Integer> birthYearBox = new JComboBox<>(nodelist);
		birthYearBox.setBounds(220, 240, 90, 20);
		add(birthYearBox);
		//combo end here*/

	
		
		//Simulate_Button
		
		JButton simulate = new JButton("Simulate");
		simulate.setBounds(220, 280,220, 35);
		add(simulate);
		simulate.addActionListener(new dfs_simulate());
		//back_dfs
		JButton back = new JButton("Back");
		back.setBounds(60,400,100,35);
		add(back);
		back.addActionListener(new back_dfs());		
	
	}
	//text1.getText()
	//return user_name
	public static int vertices() {
		return Integer.parseInt(text1.getText());
	}
	public static int start_node() {
		return Integer.parseInt(text4.getText());
	}
	public static int edge_no() {
		return edge;
	}
	
	
	

}
