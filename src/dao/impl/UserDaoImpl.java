package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import common.impl.BaseDaoHibernate;
import dao.StudentDefaultDao;
import dao.UserDao;
import domain.StudentDefault;
import domain.User;

public class UserDaoImpl extends BaseDaoHibernate<User> implements UserDao {
	@Override
	public void addUser(String user_id,StudentDefaultDao studentDefaultDao) {
		
	}

}
