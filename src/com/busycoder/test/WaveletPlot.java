package com.busycoder.test;

import java.util.Random;

public class WaveletPlot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] Y = new int[1000];
		Random rand = new Random();
		for(int i=1;i<1000;i++){
			Y[i] = 	rand.nextInt(500);		
		}
		Plot p = new Plot();
		p.plotplot(Y);
	}
}