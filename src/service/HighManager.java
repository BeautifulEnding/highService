package service;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import domain.StudentDefault;

public interface HighManager {
	//验证用户是否为当校学生
	boolean  ifExist(String username,String password);
	void addUser(String user_id);
	public JSONObject convertObjectToJSONObject(String id) throws JSONException;
	public StudentDefault getStudent(String username,String password);
}
