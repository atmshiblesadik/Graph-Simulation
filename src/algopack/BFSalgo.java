package algopack;

import framePack.*;

import java.lang.String;
import java.util.LinkedList;
import java.util.Vector;
import java.awt.*;
import javax.swing.*;


public class BFSalgo extends JPanel{
    private int live;
    private int last;
    private int count=0;
	private int start;
    private Vector<Integer> dead=new Vector<Integer>();
    private Vector<Integer> process=new Vector<Integer>();
    
    
    private boolean visit[]=new boolean[9];
    private int graph[][]=new int[9][9];
    private int node;
    private int edge;
    //2D Vector
    private Vector<Integer> pushTime[] = new Vector[9];
    //visit Time
    ///private static ArrayList<Integer> visitTime=new ArrayList<Integer>();
	private Vector<Integer> visitTime=new Vector<Integer>();
    private static String name[]= {"0","1","2","3","4","5","6","7","8"};
    private static int[][] line = {{410,317},
                            {260,217},
    			   {560,217},
                           {260,417},
                           {560,417},
                           {160,317},
                           {710,317},
                           {410,117},
                           {410,517}};
    private static int[][] nodeXY = {{400,300},
                            {250,200},
                            {550,200},
                            {250,400},
                            {550,400},
                            {150,300},
                            {700,300},
                            {400,100},
                            {400,500}};
	int x=0,y=0;
    public BFSalgo(int node,int edge,int graph[][],int start){
		
		System.out.println("in bfs parameter");
        this.edge=edge;
        this.node=node;
        this.graph=graph;
        this.count=0;
		for(int i=0;i<=8;i++){
			this.visit[i]=false;
		}
        bfs(start);
        System.out.println("After bfs");
    }
	public BFSalgo(){
		MainFrame reFrame=MainFrame.getRef();
		reFrame.repaint();
		this.setLayout(null);
		this.setName("BFS Simulation");
		this.setSize(800,600);
		this.setLocation(200,80);
		
		this.node = input_bfs.vertices();
		this.start = input_bfs.start_node();
		this.edge = input_bfs.edge_no();
		this.graph=input_bfs.graph;
		
		
		
		for(int i=0;i<this.node;i++){
			for(int j=0;j<this.node;j++){
				System.out.print(graph[i][j]);
			}
			System.out.println();
		}
		for(int i=0;i<=8;i++){
			this.visit[i]=false;
		}
        this.bfs(start);
		this.setVisible(true);
		//this.repaint();
	}
    public void bfs(int start){
		System.out.println("in bfs function");
        LinkedList<Integer> queue=new LinkedList<Integer>();
        this.visit[start]=true;
        queue.add(start);
        while(!queue.isEmpty()){
            start=queue.poll();
            visitTime.add(start);
            pushTime[start]=new Vector<Integer>();
            for(int i=0;i<=this.node;i++){
                if(this.graph[start][i]==1 && visit[i]==false){
                    queue.add(i);
                    this.visit[i]=true;
                    pushTime[start].add(i);
                }
            }
        }
        System.out.println("visit time");
    	for(int i=0;i<visitTime.size();i++){
            System.out.println(visitTime.get(i));
    	}
    }


    @Override
    public void paint(Graphics g){
        super.paint(g);
        
    	g.setColor(Color.WHITE);
        g.fillRect(0,0,900,640);
   
        for(int i=0;i<node;i++)
        {
            g.setColor(Color.BLACK);
        	g.fillOval(nodeXY[i][0],nodeXY[i][1],30,25);
            g.setColor(Color.WHITE);
        	g.drawString(name[i], line[i][0],line[i][1]);
        }
        g.setColor(Color.BLACK);
        for(int i=0;i<=8;i++)
            for(int j=0;j<=8;j++)
                if(this.graph[i][j]==1)g.drawLine(this.line[i][0],this.line[i][1],this.line[j][0],this.line[j][1]);
        
        if(count>0){
            g.setColor(Color.GREEN);
            g.fillOval(nodeXY[live][0], nodeXY[live][1], 30, 25);
            g.setColor(Color.WHITE);
            g.drawString(name[live], line[live][0],line[live][1]);
            
            if(last!=999){
                g.setColor(Color.BLUE);
                g.drawLine(this.line[live][0],this.line[live][1],this.line[last][0],this.line[last][1]);
            }
            
            for(int i=0;i<process.size();i++){
                int pro=process.get(i);
                if(pro!=live){
                    g.setColor(Color.BLUE);
                    g.fillOval(nodeXY[pro][0], nodeXY[pro][1], 30, 25);
                    g.setColor(Color.WHITE);
                    g.drawString(name[pro], line[pro][0],line[pro][1]);
                }
            }
            for(int i=0;i<dead.size();i++){
                int pro=dead.get(i);
                g.setColor(Color.RED);
                g.fillOval(nodeXY[pro][0], nodeXY[pro][1], 30, 25);
                g.setColor(Color.WHITE);
                g.drawString(name[pro], line[pro][0],line[pro][1]);
            }
        }
        System.out.println("After Paint");
    }
	
    public void animation(){
        count++;
        try{
            for(int i=0;i<visitTime.size();i++){
                int a=visitTime.get(i);
                this.live=a;
                Thread.sleep(1500);
                this.paint(this.getGraphics());
                for(int j=0;j<pushTime[a].size();j++){
                    int b=pushTime[a].get(j);
                    this.last=b;
                    this.process.add(b);
                    Thread.sleep(1500);
                    this.paint(this.getGraphics());
                    last=999;
                }
                this.dead.add(live);
                Thread.sleep(1500);
                this.paint(this.getGraphics());
            }
        }catch(InterruptedException ex){
            
        }
    }
}

