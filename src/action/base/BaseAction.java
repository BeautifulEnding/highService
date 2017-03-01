package action.base;

import service.HighManager;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{
	protected HighManager mgr;

	public void setMgr(HighManager mgr)
	{
		this.mgr = mgr;
	}

}
