package servlet.android;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import org.eclipse.core.internal.preferences.Base64;
import org.json.JSONObject;

import service.HighManager;
import servlet.base.BaseServlet;
@WebServlet(urlPatterns="/android/login.jsp")
public class LoginServlet extends BaseServlet {
	 public void service(HttpServletRequest request ,
				HttpServletResponse response)
				throws IOException , ServletException
			{
		 System.out.println("得到请求");
				String user = request.getParameter("user_id");
				String pass = request.getParameter("password");
				// 获取系统的业务逻辑组件
				HighManager highManager = (HighManager)getCtx().getBean("mgr");
				// 验证用户登录
				boolean userExist = highManager.ifExist(user, pass);
				response.setContentType("text/html; charset=GBK");
				// 登录成功
				if (userExist)
				{
					//在服务器端追踪用户登录信息，未使用？？？
					request.getSession(true).setAttribute("user_id" , userExist);
				}
				// 把验证成功的用户的信息封装成JSONObject,该用户已成功登录，ID存在于数据库中
				JSONObject jsonObj;
				try {
					jsonObj = highManager.convertObjectToJSONObject(user);
					/*//得到图片的路径
					String photo=jsonObj.getString("user_photo");
					//从指定路径读入图片字节流
			        InputStream is = new FileInputStream(photo);  
			        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
			        int b = 0;  
			        while((b = is.read())!=-1){  
			            baos.write(b);  
			        }  
			        //将字节流转换成图片
			        //ImageIcon image = new ImageIcon(baos.toByteArray());  
			        //将图片存入到jsonObject中
			        //jsonObj.append("personPhoto",image);
			        //String imageBase64 =Base64.encodeToSring();
			        jsonObj.remove("user_photo");
			        //将字节数组转换成字符串存入到jsonObject中,其中转换编码为Base64
			        String photo1=new String(Base64.encode(baos.toByteArray()));
			        jsonObj.put("user_photo",photo1);*/
					// 输出响应
					response.getWriter().println(jsonObj.toString());
				} catch (org.json.JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
}
