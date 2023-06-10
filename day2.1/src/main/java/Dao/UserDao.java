package Dao;

import java.sql.SQLException;

import Pojo.User;

public interface UserDao {
	
	User authenticateUser(String email,String password) throws SQLException;
}
