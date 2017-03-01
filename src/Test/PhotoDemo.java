package Test;
import java.io.*;  

import javax.swing.*;  

import org.json.JSONObject;
public class PhotoDemo {
	public static void main(String args[]) throws Exception{  
        
//        //源文件，必须存在，路径可选  
//		//两种写法都可以
//        //File sourceFile = new File("G:/Threesmall/technology/highservice/images/replacephoto.jpg");    
//		File sourceFile = new File("G:/Threesmall/technology/highservice/images/replacephoto.jpg"); 
//        //目的文件，因为要向其中写入，指定文件可以不存在，由程序生成  
          File destFile = new File("G:/Threesmall/technology/highservice/images/indexbg.jpg");  
//        new ReadWriteGra(sourceFile,destFile);  
          new UseGra(destFile);  
		//JSONObject json=new JSONObject();
		//json.put("name", new String[]{"hehehe","hahahha"});
		//json.put("path","G:/Threesmall/technology/highservice/images/dest.jpg");
		//String path=json.getString("path");
		//String name=json.getString("name");
		//System.out.println(name);
		//System.out.println(path);
        //System.out.print("haha");
    }  
}
//读写图片
class ReadWriteGra   
{  
    FileInputStream in = null;  
    FileOutputStream out = null;  
    public ReadWriteGra(File sourceFile,File destFile) throws Exception{  
        byte[] buf = new byte[1024];  
        int len = 0;  
        in = new FileInputStream(sourceFile);  
        out = new FileOutputStream(destFile,true); 
        //从文件输入流中读取字节，一次最多读取1024个字节
        while( (len = in.read(buf)) != -1 ){ 
        	//读到输出流
            out.write(buf,0,len);  
        }  
        out.close();  
        in.close();
    }  
}  
class UseGra extends JFrame  
{  
	public String hehe=null;
	ByteArrayOutputStream baos;
    public UseGra(File picFile) throws Exception{  
  
        this.setVisible(true);  
        this.setResizable(false);  
        this.setLayout(null);  
        this.setBounds(600, 200, 400, 370);  
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
        JPanel p1 = (JPanel)this.getContentPane();  
        p1.setOpaque(false);  
        p1.setLayout(null); 
        //从指定路径读入字节流
        String path="G:/Threesmall/technology/highservice/images/indexbg.jpg";
        InputStream is = new FileInputStream(path);  
        baos = new ByteArrayOutputStream();  
        int b = 0;  
        while((b = is.read())!=-1){  
            baos.write(b);  
        } 
        //hehe=baos.toByteArray().toString();
        //将字节流转换成图片
        ImageIcon image = new ImageIcon(baos.toByteArray());  
        JLabel background = new JLabel(image);  
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));  
        background.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());  
        JButton bt = new JButton("Test_Button");  
        p1.add(bt);  
        bt.setBounds(10,10,150,25);  
        validate();  
    }  
	
}  