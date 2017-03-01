package bean;

import javax.persistence.Column;

public class Student {
	//学生账号
	private String id;
	//学生姓名
	private String name;
	//学生密码
	private String pass;
	//学生性别
	private String sex;
	//学生生日
	private String birthday;
	//学生电话
	private String tel;
	//学生头像
	private String photo;
	//学生自我介绍
   private String self;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getBirthday() {
	return birthday;
}
public void setBirthday(String birthday) {
	this.birthday = birthday;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
public String getSelf() {
	return self;
}
public void setSelf(String self) {
	this.self = self;
}
	
}
