package Test;

import java.awt.Button;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridLayoutDemo extends JFrame{
	//定义16个按钮的显示内容
		private char[] contents="789/456*123-0.=+".toCharArray();
		//定义16个按钮
		private Button[] contentButtons=new Button[16];
		public GridLayoutDemo(){
			 //设置窗口大小
	        this.setSize(100, 100);
	        //设置窗口位于屏幕中间
	        this.setLocationRelativeTo(null);
	        //设置窗口大小不可改变
	        this.setResizable(true);
	        this.setFocusableWindowState(true);
	        //设置窗口可见
	        this.setVisible(true);
	        this.getContentPane().setLayout(null);
	        //this.getContentPane().se
	        JPanel panel=new JPanel();
	        panel.setLayout(new GridLayout(4,4));
	        for(int i=0;i<contentButtons.length;i++){
				contentButtons[i]=new Button(contents[i]+"");
				panel.add(contentButtons[i]);
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         new GridLayoutDemo();
	}

}
