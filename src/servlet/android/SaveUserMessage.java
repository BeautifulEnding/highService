package servlet.android;
//加入唯一标识，activity中应保存之前存在过的listView
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







import sql.SqlUtil;

@WebServlet(urlPatterns="/android/saveUserMessage.jsp")
public class SaveUserMessage extends HttpServlet {
	
	String path ="D:/Tomcat8/webapps/highservice/contentPhoto/user_photo";
	File defaultFile=new File(path);
    boolean uploadSuccuss=true;
    String[] fileExist=defaultFile.list();

	/**
	 * Constructor of the object.
	 */
	public SaveUserMessage() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
System.out.println("服務器接收到get請求");
	}
	

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("服务器接收到post请求");
		FileOutputStream fos=null;
		Map<String,String> map=new HashMap<>();
	    String changed=request.getParameter("changed");
	    int user_id=Integer.parseInt(request.getParameter("user_id"));
	    if (changed!=null) {
			map.put("student_name", request.getParameter("user_name"));
			map.put("student_tel", request.getParameter("user_tel"));
			map.put("student_self", request.getParameter("user_self"));
			map.put("student_age", request.getParameter("user_birthday"));
			map.put("student_sex", request.getParameter("user_sex"));
		}
	    String photoChanged=request.getParameter("photo_changed");
	    if (photoChanged!=null) {
//			map.put("user_photo", request.getParameter("user_photo"));
	    	String name=user_id+".png";
	    	map.put("student_photo", name);
			if (!fileExist(name)) {
       		 fos = new FileOutputStream(path+"/" + name);
                byte[] buf = new byte[2014];
                byte[] photo=request.getParameter("user_photo").getBytes();
                int length=photo.length;
                fos.write(photo, 0, length);
                fos.close();
			}
            else {
				File file=new File(path+"\\"+name);
				file.delete();
				 fos = new FileOutputStream(path+"/" + name);
	             byte[] buf = new byte[2014];
	             byte[] photo=request.getParameter("user_photo").getBytes();
	             int length=photo.length;
	             fos.write(photo, 0, length);
	             fos.close();
			}
		}
	    
	    if (!map.isEmpty()) {
			try {
				SqlUtil.saveUserMessage(map,user_id);
				response.getWriter().println("上传成功，已保存");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	    
	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
	private boolean fileExist(String name){
		for (String fileName: fileExist) {
			if (name.equals(fileName)) {
				return true;
			}
		}
		return false;
	}

}
