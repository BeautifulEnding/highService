package util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.enterprise.inject.New;

import org.eclipse.core.internal.preferences.Base64;
import org.json.JSONException;
import org.json.JSONObject;


public class DownLoadImageThread extends Thread{
	String name="";
	JSONObject object;
	String fileName="";
	public DownLoadImageThread(String name,JSONObject object,String fileName){
		this.name=name;
		this.object=object;
		this.fileName=fileName;
	}
	@Override
	public void run() {
	        try {
				String path="E:\\MyEclipse EE\\auction\\upload\\";
				InputStream is = new FileInputStream(path+fileName);  
		        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
		        int b = 0;  
		        while((b = is.read())!=-1){  
		            baos.write(b);  
		        }  
				object.put(name, new String(Base64.encode(baos.toByteArray())));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	}

}
