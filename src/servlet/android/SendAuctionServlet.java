package servlet.android;
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

@WebServlet(urlPatterns="/android/receiveContent.jsp")
public class SendAuctionServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SendAuctionServlet() {
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
        long tag=Long.parseLong(request.getParameter("tag"));
        System.out.println("服务器接收到post请求"+"tag的值"+tag);
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		PrintWriter out = response.getWriter();
		try {
			List<JSONObject> objects=SqlUtil.getContents(request.getParameter("topic"), tag);
//		   判断图片线程是否执行完
			if (objects.size()==0) {
				JSONObject object=new JSONObject();
				if (tag==0) {
					System.out.println("没有内容");
					object.put("update", "noContent");
				}else {
					System.out.println("已是最新");
					object.put("update", "noUpdate");
				}
				out.println(object.toString());
			} else {
				for (int i = 0; i < objects.size(); i++) {
					out.println(objects.get(i).toString());
				}
			}
			out.flush();
			out.close();
System.out.println("完成");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

}
