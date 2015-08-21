package com.busycoder.test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class Figure  extends JPanel {  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int[] Y; // y axis points
	public Figure(int[] y) {  
		this.Y = new int[y.length];
		for(int i=0;i<y.length;i++){
			this.Y[i] = y[i];
		}
	}  
	//  paint the x-y axis and data  
	public void paintComponent(Graphics g) {  
		super.paintComponent(g);  
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLUE); // set color : blue
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  
		int xwidth = this.getWidth();  
		int paintLen = xwidth-1;
		if(this.Y.length<xwidth){
			paintLen = this.Y.length-1;
		}
		int i = 1;
		while(i<paintLen){  
			g2d.drawLine(i, Y[i-1], i+1, Y[i]);
		    i++;  
		}  
	}   
	
	// return the max value of Y
	public int getMaxY(){
		if(Y.length==0){
			return this.getHeight();
		}
		int maxValue = Integer.MIN_VALUE;
		for(int i=0; i<Y.length; i++){
			if(Y[i]>maxValue){
				maxValue = Y[i];
			}
		}
		return maxValue;	
	}
}