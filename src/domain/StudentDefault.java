package domain;

import javax.persistence.*;

@Entity
@Table(name="studentdefault")
public class StudentDefault {
	@Id
	@Column(name="Student_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	//学生姓名
	@Column(name="Student_name")
	private String name;
	//学生密码
	@Column(name="Student_pass")
	private String pass;
	//学生性别
	@Column(name="Student_sex")
	private String sex;
	//学生年龄
	@Column(name="Student_age")
	private String age;
	//学生电话
	@Column(name="Student_tel")
	private String tel;
	//学生头像
	@Column(name="student_photo")
	private String photo;
	//学生自我介绍
	@Column(name="student_self")
	private String self;
	
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int hashCode()
	{
		return 0;
	}

	public boolean equals(Object obj)
	{
		return false;
	} 
}
