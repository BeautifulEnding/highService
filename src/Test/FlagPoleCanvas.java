package Test;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class FlagPoleCanvas extends Canvas{
	public FlagPoleCanvas(){
		
	}
	@Override
	public void paint(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
	}

}
