package action;

import java.util.Map;

import action.base.BaseAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends BaseAction{
	//定义封装请求参数的username和password成员变量
	private String username;
	private String password;
	private String vercode;
	//定义处理用户请求的execute方法
	public String execute() throws Exception{
		
		Map session = ActionContext.getContext().getSession();
		String ver2 = (String )session.get("rand");
		// 清空Session中的随机验证码字符串。
		session.put("rand" , null);
		if (vercode.equals(ver2))
		{
			boolean exist = mgr.ifExist(username,password);
			if (exist)
			{
				session.put("user_id", username);
				return SUCCESS;
			}
			else
			{
				addActionError("用户名/密码不存在，请核对！");
				return "failure";
			}
		}
		else
		{
			addActionError("验证码不匹配,请重新输入");
			return "failure";
		}
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVercode() {
		return vercode;
	}
	public void setVercode(String vercode) {
		this.vercode = vercode;
	}
	
}
