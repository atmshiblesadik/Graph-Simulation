
package algopack;
import framePack.*;

import java.lang.String;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.awt.*;
import javax.swing.JPanel;
import framePack.input_dfs;

public class DFSalgo extends JPanel{
    private int live;
    private int last;
    private int count=0;
    private Vector<Integer> dead=new Vector<Integer>();
    private Vector<Integer> process=new Vector<Integer>();
    
    
    private boolean visit[]=new boolean[9];
    private int graph[][]=new int[9][9];
    private int node;
    private int edge;
    //2D Vector
    private Vector<Integer> pushTime[] = new Vector[9];
	private Vector<Integer> visitTime;
	private Vector<Integer> deadTime=new Vector<Integer>();
	
	private Vector<Integer> parentXY[]=new Vector[9];
	
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
    
    

	public DFSalgo(){
		MainFrame reFrame=MainFrame.getRef();
		reFrame.repaint();
		this.setLayout(null);
		this.setName("DFS Simulation");
		this.setSize(800,600);
		this.setLocation(200,80);
		
		this.node = input_dfs.vertices();
		int start = input_dfs.start_node();
		this.edge = input_dfs.edge_no();
		this.graph=input_dfs.graph;
		
		
		
		
		for(int i=0;i<=8;i++){
			this.visit[i]=false;

	    	this.pushTime[i]=new Vector<Integer>();
		}
		this.visitTime=new Vector<Integer>();
        this.dfs(start);
		this.setVisible(true);
		
		for(int i=0;i<this.node;i++) {
			System.out.print(i + " ");
			for(int j=0;j<this.pushTime[i].size();j++) {
				System.out.print(this.pushTime[i].get(j) + " ");
			}
			System.out.println();
		}
		
		//this.repaint();
	}
	
	
    public void dfs(int start){
    	this.visit[start]=true;
    	this.visitTime.add(start);
    	for(int i=0;i<this.node;i++) {
    		if(this.visit[i]==false && this.graph[start][i]==1) {
    			this.pushTime[start].add(i);
    			dfs(i);
    		}
    		//g2.drawLine(line[start][0],line[start][1],line[i][0],line[i][1]);
    	}
    	deadTime.add(start);
    }

    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        int x=350;
        int y=100;
        int px,py;
        boolean[] printed=new boolean[9];
        for(int i=0;i<9;i++) {
        	printed[i]=false;
        }
        int[][] printxy=new int[9][2];
        printxy[0][0]=x;
        printxy[0][1]=y;
        int xx,yy;
        for(int i=0;i<visitTime.size();i++) {
        	int a=visitTime.get(i);
        	px=printxy[a][0];
        	py=printxy[a][1];
        	if(printed[a]==false) {
	        	g.setColor(Color.BLACK);
	        	g.fillOval(printxy[a][0],printxy[a][1], 30, 25);
	        	g.setColor(Color.WHITE);
	        	g.drawString(name[a], printxy[a][0]+10, printxy[a][1]+17);
	        	printed[a]=true;
        	}
        	xx=printxy[a][0];
    		yy=printxy[a][1]+100;
 
	    		if(this.pushTime[a].size()%2==0 && this.pushTime[a].size()>0) {
	    			xx=printxy[a][0]-(this.pushTime[a].size()/2)*80-40;
	    			for(int j=0;j<this.pushTime[a].size()/2;j++) {
	    				xx+=80;
	    				int b=this.pushTime[a].get(j);
	    				g.setColor(Color.BLACK);
	    	        	g.fillOval(xx, yy, 30, 25);
	    	        	printxy[b][0]=xx;
	    	        	printxy[b][1]=yy;
	    	        	g.setColor(Color.WHITE);
	    	        	g.drawString(name[b], xx+10, yy+17);
	    	        	g.setColor(Color.BLACK);
	    	        	g.drawLine(px+15, py+12, xx+10, yy+10);
	    	        	System.out.println(this.pushTime[a].get(j));
	    	        	printed[this.pushTime[a].get(j)]=true;
	    	        	
	    			}
	    			
	    			for(int j=this.pushTime[a].size()/2;j<this.pushTime[a].size();j++) {
	    				int b=this.pushTime[a].get(j);
	    				xx+=80;
	    				g.setColor(Color.BLACK);
	    	        	g.fillOval(xx, yy, 30, 25);
	    	        	printxy[b][0]=xx;
	    	        	printxy[b][1]=yy;
	    	        	g.setColor(Color.WHITE);
	    	        	g.drawString(name[b], xx+10, yy+17);
	    	        	g.setColor(Color.BLACK);
	    	        	g.drawLine(px+15, py+12, xx+10, yy+10);
	    	        	System.out.println(this.pushTime[a].get(j));
	    	        	printed[this.pushTime[a].get(j)]=true;
	    	        	
	    			}
	    		}else if(this.pushTime[a].size()%2!=0 && this.pushTime[a].size()>1){
	    			xx=printxy[a][0]-(this.pushTime[a].size()/2)*80-40;
	    			for(int j=0;j<this.pushTime[a].size()/2;j++) {
	    				xx+=80;
	    				int b=this.pushTime[a].get(j);
	    				g.setColor(Color.BLACK);
	    	        	g.fillOval(xx, yy, 30, 25);
	    	        	printxy[b][0]=xx;
	    	        	printxy[b][1]=yy;
	    	        	g.setColor(Color.WHITE);
	    	        	g.drawString(name[b], xx+10, yy+17);
	    	        	g.setColor(Color.BLACK);
	    	        	g.drawLine(px+15, py+12, xx+10, yy+10);
	    	        	System.out.println(this.pushTime[a].get(j));
	    	        	printed[this.pushTime[a].get(j)]=true;
	    	        	
	    			}
	    			
	    			if(this.pushTime[a].size()>=1) {
		    			for(int j=this.pushTime[a].size()/2;j<this.pushTime[a].size();j++) {
		    				int b=this.pushTime[a].get(j);
		    				xx+=80;
		    				g.setColor(Color.BLACK);
		    	        	g.fillOval(xx, yy, 30, 25);
		    	        	printxy[b][0]=xx;
		    	        	printxy[b][1]=yy;
		    	        	g.setColor(Color.WHITE);
		    	        	g.drawString(name[b], xx+10, yy+17);
		    	        	g.setColor(Color.BLACK);
		    	        	System.out.println(this.pushTime[a].get(j));
		    	        	printed[this.pushTime[a].get(j)]=true;
		    	        	g.drawLine(px+15, py+12, xx+10, yy+10);
		    	        
		    			}
	    			}		
	    		}else if(this.pushTime[a].size()==1) {
	    			int b=this.pushTime[a].get(0);
    				g.setColor(Color.BLACK);
    	        	g.fillOval(xx, yy, 30, 25);
    	        	printxy[b][0]=xx;
    	        	printxy[b][1]=yy;
    	        	g.setColor(Color.WHITE);
    	        	g.drawString(name[b], xx+10, yy+17);
    	        	g.setColor(Color.BLACK);
    	        	g.drawLine(px+15, py+12, xx+10, yy+10);
    	        	System.out.println(b);
    	        	printed[b]=true;
	    			
	    		}
	    		
        	
        	
        	
        }
        
        
                
    
    }
	
    /*
    public void animation(){
        count++;
        try{
            Thread.sleep(1500);
            this.paint(this.getGraphics());
                
            
        }catch(InterruptedException ex){
            
        }
    }
    */
}

