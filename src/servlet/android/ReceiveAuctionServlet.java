package servlet.android;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
 
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
 
import org.apache.commons.fileupload.util.Streams;

import sql.SqlUtil;
@WebServlet(urlPatterns="/android/sendContent.jsp")
public class ReceiveAuctionServlet extends HttpServlet {
	String path ="D:/Tomcat8/webapps/highservice/contentPhoto";
	File defaultFile=new File(path);
    boolean uploadSuccuss=true;
    String[] fileExist=defaultFile.list();
	/**
	 * Constructor of the object.
	 */
	public ReceiveAuctionServlet() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
	@SuppressWarnings("deprecation")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> params=new HashMap<String, String>();
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		boolean isMultiPart=ServletFileUpload.isMultipartContent(request);
		InputStream is=null;
		FileOutputStream fos=null;
		int photoNum=0;
		try {
			if (isMultiPart) {
				ServletFileUpload upload=new ServletFileUpload();
				FileItemIterator iterator=upload.getItemIterator(request);
				while (iterator.hasNext()) {
	                  FileItemStream fis =iterator.next();
	                  //是multipart就表示需要使用字节数据进行传递，需要使用输入流
	                  is = fis.openStream();
	                  if (fis.isFormField()) {
	                     String value=Streams.asString(is, "utf8");
	                     System.out.println(fis.getFieldName()+"  "+value);
	                     params.put(fis.getFieldName(), value);
	                     
	                  } else {
	                	 photoNum++;
	                	 params.put("image"+photoNum, fis.getName());
	                	 System.out.println(fis.getName());
	                	 if (!fileExist(fis.getName())) {
	                		 fos = new FileOutputStream(path+"/" + fis.getName());
		                     byte[] buf = new byte[2014];
		                     int len = 0;
		                     while((len=is.read(buf))>0){
		                         fos.write(buf,0,len);
		                     }
						}
	                     else {
							System.out.println("该图片已存在");
						}
	                  }
	              }
	           }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			uploadSuccuss=false;
		}
		finally{
			
			 if(is!=null) is.close();
	         if(fos!=null) fos.close();
		}
        response.getWriter().println("上傳成功");
        SqlUtil.updateContent(params);
    } 
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		File file=new File(path);
		if (file.exists()) {
			file.mkdir();
		}
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
