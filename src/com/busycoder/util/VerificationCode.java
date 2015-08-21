package com.busycoder.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/*
 * ������֤��ͼƬ
 * ����ͼƬ�е��ַ�
 */
public class VerificationCode {
	private final static int RGBMaxValue = 255;
	private final static String codeChars = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private int width;
	private int height;
	private BufferedImage image; //������֤��ͼƬ
	private StringBuilder sb;	// ��֤���е��ַ�

	public VerificationCode(){
		width = 90;
		height = 20;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);	//��֤��ͼƬ
		sb = new StringBuilder();	//������������ַ�
	}
	
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public StringBuilder getSb() {
		return sb;
	}

	public void setSb(StringBuilder sb) {
		this.sb = sb;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}	
	
	protected Color getRandomColor(){	//�������һ����ɫ
		Random rand = new Random();
		int red = rand.nextInt(RGBMaxValue);
		int green = rand.nextInt(RGBMaxValue);
		int blue = rand.nextInt(RGBMaxValue);
		return (new Color(red, green, blue));
	}
	
	protected Color getRandomColor(int minColor, int maxColor){	//overwrite
		Random rand = new Random();
		if(minColor>255){
			minColor = 255;			
		}
		if(maxColor>255){
			maxColor = 255;
		}
		int red = minColor + rand.nextInt(maxColor - minColor);
		int green = minColor + rand.nextInt(maxColor - minColor);;
		int blue = minColor + rand.nextInt(maxColor - minColor);;
		return (new Color(red, green, blue));
	}
	
	public void generateImage(){	//��֤��ͼƬ����
		Random rand = new Random();
		Graphics g = image.getGraphics();	//����
		g.setColor(getRandomColor(180, 250));	//�������ɫ
		g.fillRect(0, 0, width, height);	//����������
		//g.setFont(new Font("Times New Roman", Font.ITALIC, height));	//��������
		//g.setColor(getRandomColor(120, 180));	//����������ɫ
		String[] font = {"Times New Roman", "Book antiqua", "Arial"};
		for(int i=0; i<4; i++){
			g.setFont(new Font(font[rand.nextInt(font.length)], Font.ITALIC, height));;
			g.setColor(getRandomColor(10, 100));	//����������ɫ
			char c = codeChars.charAt(rand.nextInt(codeChars.length()));
			sb.append(c);
			g.drawString(String.valueOf(c), 5 + 18*i + rand.nextInt(10), height - rand.nextInt(5));			
		}
		g.dispose();  // �ر�Graphics
	}
}
