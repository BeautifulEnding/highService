package dao;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import bean.Student;
import common.BaseDao;
import domain.StudentDefault;

public interface StudentDefaultDao extends BaseDao<StudentDefault> {
public StudentDefault findByNameAndPassword(String username,String password);
public JSONObject getAllMessages(String userId) throws JSONException;
}
