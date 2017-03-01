package dao.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.json.JSONException;
import org.json.JSONObject;

import bean.Student;
import common.impl.BaseDaoHibernate;
import dao.StudentDefaultDao;
import domain.StudentDefault;

public class StudentDefaultDaoImpl extends BaseDaoHibernate<StudentDefault> implements StudentDefaultDao {

	@Override
	public StudentDefault findByNameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		// 执行HQL查询
				List<StudentDefault> ul = (List<StudentDefault>)find(
					"from StudentDefault au where au.id=?0 and au.pass=?1" ,
					username , password);
				// 返回查询得到的第一个StudentDefault对象
				if (ul.size() == 1)
				{
					return (StudentDefault)ul.get(0);
				}
				return null;
	}

	@Override
	public JSONObject getAllMessages(String userId) throws JSONException {
		// TODO Auto-generated method stub
	   StudentDefault allMessages=get(StudentDefault.class,userId);
	   JSONObject jsonObject=new JSONObject();
	   jsonObject.put("user_id",allMessages.getId());
	   jsonObject.put("user_password", allMessages.getPass());
	   jsonObject.put("user_birthday", allMessages.getAge());
	   jsonObject.put("user_sex", allMessages.getSex());
	   jsonObject.put("user_name", allMessages.getName());
	   jsonObject.put("user_self", allMessages.getSelf());
	   jsonObject.put("user_tel",allMessages.getTel());
	   jsonObject.put("user_photo", allMessages.getPhoto());
	   System.out.println(jsonObject.toString());
	   return jsonObject;
	}


}
