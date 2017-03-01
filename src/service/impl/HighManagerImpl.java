package service.impl;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.AppointmentDao;
import dao.HelpDao;
import dao.MessageDao;
import dao.StudentDefaultDao;
import dao.UserDao;
import domain.StudentDefault;
import service.HighManager;
@Service
public class HighManagerImpl implements HighManager{
	//定义业务逻辑所需要的Dao组件
    private StudentDefaultDao studentDefaultDao;
    private UserDao userDao;
    private AppointmentDao appointmentDao;
    private HelpDao helpDao;
    private MessageDao messageDao;
    //getter和setter方法 
	public StudentDefaultDao getStudentDefaultDao() {
		return studentDefaultDao;
	}

	public void setStudentDefaultDao(StudentDefaultDao studentDefaultDao) {
		this.studentDefaultDao = studentDefaultDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
    
	public AppointmentDao getAppointmentDao() {
		return appointmentDao;
	}

	public void setAppointmentDao(AppointmentDao appointmentDao) {
		this.appointmentDao = appointmentDao;
	}

	public HelpDao getHelpDao() {
		return helpDao;
	}

	public void setHelpDao(HelpDao helpDao) {
		this.helpDao = helpDao;
	}

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	 @Transactional
	public boolean ifExist(String username, String password) {
		// TODO Auto-generated method stub
		if((studentDefaultDao.findByNameAndPassword(username, password))!=null){
			return true;
		}
		return false;
	}
	 public StudentDefault getStudent(String username,String password){
		 
		 return studentDefaultDao.findByNameAndPassword(username, password);
	 }
	 @Transactional
	public void addUser(String user_id) {
		// TODO Auto-generated method stub
		userDao.addUser(user_id, studentDefaultDao);
	}

	/*@Override
	public int validLogin(String user, String pass) {
		// TODO Auto-generated method stub
		return 0;
	}*/
	 @Override
    public JSONObject convertObjectToJSONObject(String id) throws JSONException{
    	JSONObject jsonObject=new JSONObject();
    	jsonObject=studentDefaultDao.getAllMessages(id);
    	return jsonObject;
    }
}
