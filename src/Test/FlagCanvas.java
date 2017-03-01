package Test;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;

public class FlagCanvas extends Canvas{
	private int FLAG_WIDTH,FLAG_HEIGHT,FLAG_X,FLAG_Y;
	public FlagCanvas(){
		this.FLAG_HEIGHT=100;
		this.FLAG_WIDTH=200;
		this.FLAG_X=0;
		this.FLAG_Y=660;
	}
	@Override
	public void paint(Graphics g){
		//设置图像颜色为红色
		g.setColor(Color.red);
		//g.fillRect(this.FLAG_X, this.FLAG_Y, this.FLAG_X+FLAG_WIDTH, this.FLAG_Y+FLAG_HEIGHT);
		//g.fillRect(this.FLAG_X, this.FLAG_Y, FLAG_WIDTH, this.FLAG_Y+this.FLAG_HEIGHT);
		//x - the x coordinate of the rectangle to be filled. 
		//y - the y coordinate of the rectangle to be filled. 
		//width - the width of the rectangle to be filled. 
		//height - the height of the rectangle to be filled. 
		g.fillRect(this.FLAG_X, this.FLAG_Y, FLAG_WIDTH, this.FLAG_HEIGHT);
		if(this.FLAG_Y>=40){
			this.FLAG_Y=this.FLAG_Y-20;
		}
		//System.out.println(Integer.toString(this.FLAG_Y));
	}
	/*@Override
	    public void update(Graphics g){
	    	paint(g);
	    }*/
}
