package dao;

import common.BaseDao;
import domain.User;

public interface UserDao extends BaseDao<User>{
	public void addUser(String username,StudentDefaultDao studentDefaultDao);		
}
