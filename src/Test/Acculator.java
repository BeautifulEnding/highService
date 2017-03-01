package Test;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Acculator extends JFrame implements ActionListener{
	//文本行内容
	private String haha="";
	//定义窗口大小
	private int FRAME_WIDTH=650,FRAME_HIGHT=435;
	
	//定义屏幕大小
	Dimension size;
	//定义内容窗格
	JPanel p1;
	//定义16个按钮的显示内容
	private char[] contents="789/456*123-0.=+".toCharArray();
	//定义16个按钮
	private Button[] contentButtons=new Button[16];
    //定义一个文本框显示结果
	private TextField result;
	//定义构造方法
	public Acculator() throws IOException{
		//得到屏幕的大小
         size=this.getToolkit().getScreenSize();
		//设置网格布局
        //this.setLayout(new GridLayout(5,1));
		this.setLayout(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
        //得到内容窗格
        p1 = (JPanel)this.getContentPane(); 
        //设置内容窗格透明
        p1.setOpaque(false);       
        //p1.setLayout(new GridLayout(5,1)); 
        p1.setLayout(null);
		//从指定路径读入图片
        String path="G:/Threesmall/technology/highservice/images/jisuanqi.jpg";
        InputStream is = new FileInputStream(path);  
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
        int b = 0;  
        while((b = is.read())!=-1){  
            baos.write(b);  
        } 
        //将字节流转换成图片
        ImageIcon image = new ImageIcon(baos.toByteArray());  
        JLabel background = new JLabel(image); 
        //background.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());  
        //background.setBounds(0, 0, this.getWidth(), this.getHeight()); 
        //background.setBounds(0, 0, (int)size.getWidth()/3, (int)size.getHeight()/3);
        background.setSize((int)size.getWidth()/3, 435);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));  
        //初始化计算器
        init();
        //设置窗口大小
        this.setSize(FRAME_WIDTH, FRAME_HIGHT);
        //设置窗口位于屏幕中间
        this.setLocationRelativeTo(null);
        //设置窗口大小不可改变
        this.setResizable(true);
        this.setFocusableWindowState(true);
        //设置窗口可见
        this.setVisible(true);
        
        
	}
	private void init(){
		//p1.setBounds(0, 30, (int)size.getWidth()/4,(int)size.getHeight()/3);
		//p1.setSize((int)size.getWidth()/4,(int)size.getHeight()/3);
		p1.setBackground(Color.green);
		//设置文本行
		result=new TextField("结果",5);
		result.setBounds(0, 0, (int)size.getWidth()/4, 30);
		//将文本框加入面板中
		p1.add(result);
		//将按钮放在按钮面板中
		JPanel buttonsPanel=new JPanel();
		buttonsPanel.setLayout(new GridLayout(5,4));
		buttonsPanel.setBounds(0, 30, (int)size.getWidth()/4,(int)size.getHeight()/3);
		//定义按钮
		Button b1=new Button("1");
		b1.setSize((int)size.getWidth()/4, (int)size.getHeight()/3);
		Button b2=new Button("2");
		b2.setSize((int)size.getWidth()/16, (int)size.getHeight()/15);
		Button b3=new Button("3");
		b3.setSize((int)size.getWidth()/16, (int)size.getHeight()/15);
		Button b4=new Button("4");
		b4.setSize((int)size.getWidth()/16, (int)size.getHeight()/15);
		buttonsPanel.add(b1);
		buttonsPanel.add(b2);
		buttonsPanel.add(b3);
		buttonsPanel.add(b4);
		for(int i=0;i<contentButtons.length;i++){
			contentButtons[i]=new Button(contents[i]+"");
			contentButtons[i].setSize((int)size.getWidth()/16, (int)size.getHeight()/15);
			contentButtons[i].addActionListener(this);
			buttonsPanel.add(contentButtons[i]);
		}
		//buttonsPanel.setSize(50, 50);
		p1.add(buttonsPanel);
		validate(); 
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Acculator acculator=new Acculator();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==contentButtons[2]){
			haha=haha+contents[2];
			result.setText(haha);
		}
	}

}
