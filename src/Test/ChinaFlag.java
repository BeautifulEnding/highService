package Test;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.InterruptedIOException;
/**
 * Description:
 * <br>网站：<a href="http://www.baidu.com">百度一下，你就知道</a>
 * <br>Copyright (C) ,2016-2017,hequnfang
 * <br>Program is protected by copyright laws
 * <br> Program Date:
 * @author hequnfang
 * @version 1.0
 * */
public class ChinaFlag extends Frame implements WindowListener,ActionListener,Runnable{
	//定义一个线程
	Thread thread=null;
	//定义容器的宽度和高度
	private int WIDTH=300,HEIGHT=800,FLAG_POLE_WIDTH=40,PANEL_WIDTH=40;
	//定义旗画布
	private FlagCanvas flagCanvas;
	//定义旗杆画布
	private FlagPoleCanvas flagPoleCanvas;
	//定义一个容器
	private Panel panel;
	//定义两个按钮
	private Button raiseFlag,stopRaiseFlag;
	public ChinaFlag(){
		//将窗口布局设为空
		this.setLayout(null);
		this.setSize(new Dimension(WIDTH,HEIGHT));
		//窗口大小不可调整
		this.setResizable(false);
		//设置窗口位于屏幕中间
		this.setLocationRelativeTo(null);
		//增加窗口事件监听
	    this.addWindowListener(this);
		//增加面板
		panel=new Panel();
		//设置面板背景色
		panel.setBackground(Color.BLUE);
		//设置面板边界
		//panel.setBounds(HEIGHT-100, 0, HEIGHT, WIDTH);
		panel.setBounds(0, HEIGHT-PANEL_WIDTH, WIDTH, HEIGHT);
		//增加两个按钮
		raiseFlag=new Button("raise");
		stopRaiseFlag=new Button("stop");
		stopRaiseFlag.setEnabled(false);
		//为按钮增加动作监听
		raiseFlag.addActionListener(this);
		stopRaiseFlag.addActionListener(this);
		//将按钮添加到面板中
		panel.add(raiseFlag);
		panel.add(stopRaiseFlag);
		//将面板加入窗口容器
		this.add(panel);
		//增加旗帜画布
		flagCanvas=new FlagCanvas();
		flagCanvas.setBackground(Color.green);
		flagCanvas.setBounds(FLAG_POLE_WIDTH, 0, WIDTH, HEIGHT-PANEL_WIDTH);
		//将画布增加到容器中
		this.add(flagCanvas);
		//增加旗杆画布
		flagPoleCanvas =new FlagPoleCanvas();
		flagPoleCanvas.setBounds(0, 0, FLAG_POLE_WIDTH, HEIGHT-PANEL_WIDTH);
		//将画布增加到容器中
		this.add(flagPoleCanvas);
		//容器可见
		this.setVisible(true);
	}
	public static void main(String[] args){
		  new ChinaFlag();
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @param name 该参数指定响应事件
	 * @return 该返回值为空
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==stopRaiseFlag){
			thread.interrupt();
			System.out.println(thread.getState().toString());
			stopRaiseFlag.setEnabled(false);
        	raiseFlag.setEnabled(true);
		}
		if(e.getSource()==raiseFlag){
			//线程中断后就没有了
			thread=new Thread(this);
			thread.start();
			stopRaiseFlag.setEnabled(true);
        	raiseFlag.setEnabled(false);
		}
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				flagCanvas.repaint();
				System.out.println(thread.getState().toString());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				break;
			}
		}
	}
	
}

