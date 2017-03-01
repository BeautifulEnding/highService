package sql;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.core.internal.preferences.Base64;
import org.json.JSONObject;

import sun.net.www.content.text.plain;
import util.DownLoadImageThread;

public class SqlUtil {
	public static String USER_IMAGE_PATH="G:/Threesmall/technology/highservice/user_photo/";
	public static void updateContent(Map<String, String> params) {
		String topic=params.get("topic");
		Statement statement=connection();
		String tempSql=Integer.parseInt(params.get("id"))+
				"," +" '"+params.get("content")+"'" + ", '"+params.get("image1")+"'"  + ", '"+params.get("image2")+"'"
				+ ", '"+params.get("image3")+"'" +", '"+params.get("image4")+"'" +", '"+params.get("image5")
				+"'"+ ", '"+params.get("image6")+"'" +", '"+params.get("image7")+"'" +", '"+params.get("image8")+"'"
				+", '"+params.get("image9")+"'" +", 'null'" +", '0'"
				+", 'null'" +", '"+params.get("tag")+"',0,0,0 )";
		String sql=null;
		switch (topic) {
		case "帮助":
			sql="insert into helpmentcontent values ( ";
			break;
		case "约":
			sql="insert into appointmentcontent values ( ";
            break;
		default:
			sql="insert into onecontent values ( ";
			break;
		}
		sql=sql+tempSql;
		System.out.println(sql);
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<JSONObject> getContents(String topic,long tag) throws Exception {
//		为得到图片的所有线程建立线程池，用来判断所有的图片是否都得到
//		ExecutorService exe=Executors.newFixedThreadPool(30);
		List<JSONObject> objects=new ArrayList<>();
		String sql=null;
		String tableName="";
		String tempSql="";
		/*switch (topic) {
		case "帮助":
			tableName="helpmentcontent";
			break;
		case "约":
			tableName="appointmentcontent";
			break;
		case ""
		default:
//			默认情况下得到所有话题表中的数据
			tableName="onecontent";
			break;
		}*/
		if (topic.equals("所有")) {
//			得到所有话题表中的内容
			tempSql="select topictable_name from topic";
			Statement statement=SqlUtil.connection();
			ResultSet set=statement.executeQuery(tempSql);
			while (set.next()) {
				tableName=set.getString("topictable_name");
				getContents(tempSql, tag, tableName,objects);
			}
		}else {
		    tempSql="select topictable_name from topic where topic_name= '"+topic+"'";
		    Statement statement=SqlUtil.connection();
			ResultSet set=statement.executeQuery(tempSql);
			if (set.next()) {
				tableName=set.getString("topictable_name");
				getContents(tempSql, tag, tableName,objects);
			}
			
		}
		/*exe.shutdown();
		while (true) {  
			if (exe.isTerminated()) {  
				System.out.println("结束！");  
				break;  
			}  
			Thread.sleep(500);  
		}  
*/		return objects;
	}
	public static void saveUserMessage(Map<String, String> map,int user_id) throws SQLException  {
		Statement statement=connection();
		for (Entry<String, String> entry : map.entrySet()) {
			String value=SqlUtil.USER_IMAGE_PATH+entry.getValue();
			String sql="update studentdefault set "+entry.getKey()+" = '"+value+"' where student_id ="+user_id;
			System.out.println(sql);
			statement.executeUpdate(sql);
		}
		
	}
	private static Statement connection() {
//		加载Mysql的驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			获取数据库连接
			Connection connection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/high","root","14045102");
//			使用Connection来创建一个Statement对象
			Statement statement=(Statement) connection.createStatement();
			return statement;
	       } catch (Exception e) {
		// TODO Auto-generated catch block
		                 e.printStackTrace();
	               }
		return null;
}
	
	private static void getContents(String sql,long tag,String tableName,List<JSONObject> objects) throws Exception{

		if (tag!=0) {
			sql="select * from "+tableName+" where tag > '"+tag+"'";
		}else {
			sql="select * from "+tableName+" ";
		}
System.out.println(sql);
        Statement statement=SqlUtil.connection();
		ResultSet resultSet=statement.executeQuery(sql);
		while (resultSet.next()) {
			JSONObject object=new JSONObject();
			object.put("id", resultSet.getInt("id")+"");
			object.put("content", resultSet.getString("content"));
			for (int i = 1; i <= 9; i++) {
				if (resultSet.getString(i+2).equals("null")|| resultSet.getString(i+2)==null) {
					break;
				}
//				object.put("image"+i, uploadImage(resultSet.getString(i+2)));
//				为每张图片另开一个线程，加快服务器的传输速度
//				DownLoadImageThread imageThread1=new DownLoadImageThread("image"+i, object, resultSet.getString(i+2));
//				imageThread1.start();
//				exe.execute(new DownLoadImageThread("image"+i, object, resultSet.getString(i+2)));
//			      直接将图片名传过去，Android直接根据该字段访问服务器端的图片，
//				不用通过数据流的方式传输到Android
				object.put("image"+i, resultSet.getString(i+2));
			}
//			object.put("tag", resultSet.getString("tag"));
			object.put("tag", resultSet.getLong("tag"));
			object.put("topicTableName", tableName);
			Statement statement2=connection();
			ResultSet set=statement2.executeQuery("select student_photo from studentdefault where student_id ="+resultSet.getString("id"));
			if (set.next()) {
				object.put("photo", set.getString("student_photo"));
			}else {
				object.put("photo", "default.jpg");
			}
			objects.add(object);
		}
	}
	
	public static  JSONObject findStudent(String name) throws Exception{
		Statement statement=connection();
		String sql="select * from studentdefault where student_id = "+name;
		ResultSet set=statement.executeQuery(sql);
		if (set.next()) {
			JSONObject object=new JSONObject();
			object.put("user_id", set.getString("student_id"));
			object.put("user_name", set.getString("student_name"));
			object.put("user_sex", set.getString("student_sex"));
			object.put("user_age", set.getString("student_age"));
			object.put("user_tel", set.getString("student_tel"));
			object.put("user_self", set.getString("student_self"));
			object.put("user_photo", set.getString("student_photo"));
			return object;
		}
		return null;
	}
	
}