package servlet.base;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class BaseServlet extends HttpServlet {
	private ApplicationContext ctx;
	public  void init(ServletConfig config) throws ServletException{
		super.init(config);
		//获取Web应用中的ApplicationContext实例,ApplicationContext是spring容器的子接口，代表了spring容器
		ctx=WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
	}
    public ApplicationContext getCtx(){
    	return this.ctx;
    }
}
