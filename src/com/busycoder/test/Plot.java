package com.busycoder.test;
 
import javax.swing.JFrame;

public class Plot extends JFrame{  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Plot() {  
    
	}  
	public void plotplot(int[] Y){
		setTitle("Figure"); 
		Figure fig = new Figure(Y);
		getContentPane().add(fig); 
		setSize(1000,500);
		setLocationRelativeTo(null);
		setVisible(true);	  
	}
}  