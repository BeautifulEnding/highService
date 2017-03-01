package servlet.android;

import javax.servlet.http.HttpServlet;
//加入唯一标识，activity中应保存之前存在过的listView
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import sql.SqlUtil;

@WebServlet(urlPatterns="/android/findFriend.jsp")
public class AddFriendServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddFriendServlet() {
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
		System.out.println("服务器接收到get请求");
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		String name=request.getParameter("name");
	      PrintWriter out = response.getWriter();
	      try {
	    	  JSONObject object=SqlUtil.findStudent(name);
	    	  if (object!=null) {
				/*object=new JSONObject();
				object.put("user", "noUser");*/
	    		  System.out.println("该用户存在于数据库");
	    		  out.println(object.toString());
			}
//	    	  out.println(object.toString());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
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
	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

