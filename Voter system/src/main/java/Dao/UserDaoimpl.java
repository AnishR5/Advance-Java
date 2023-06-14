package Dao;

import java.sql.*;
import java.time.LocalDate;
import java.time.Period;

import static utils.dbconnect.*;
import Pojo.User;

public class UserDaoimpl implements UserDao {
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2,pst3;
	//private PreparedStatement pst3;
	
	public UserDaoimpl() throws SQLException {
		
		cn=openconnection();
		pst1=cn.prepareStatement("select * from users where email=? and password=?");
		// id | first_name | last_name | email             | password | dob        | status | role
		pst2=cn.prepareStatement("insert into users(first_name,last_name,email,password,dob,status,role) values (?,?,?,?,?,0,'voter')");
		pst3=cn.prepareStatement("update users set status=1 where id=?");
		
		System.out.println("User dao created");
		
	}
	
	

	@Override
	public User authenticateUser(String email, String password) throws SQLException {
		pst1.setString(1, email);
		pst1.setString(2, password);
		
		try(ResultSet rs=pst1.executeQuery())
		{
			if(rs.next())
			{
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getBoolean(7), rs.getString(8));
			}
		}
		
		return null;
	}
	
	public String registeruser(String firstname,String lastname,String email, String password, String dob) throws SQLException {
		Date sqldate=Date.valueOf(dob);
		LocalDate d=LocalDate.parse(dob);
		int yrs=Period.between(d, LocalDate.now()).getYears();
		if(yrs>=21)
		{
			pst2.setString(1, firstname);
			pst2.setString(2, lastname);
			pst2.setString(3, email);
			pst2.setString(4, password);
			pst2.setDate(5, sqldate);
			
			int rowsaffected=pst2.executeUpdate();
			if(rowsaffected==0) {
				return "fail";
			}
			else {
				return "success";
			}
		}
		else
			return "fail";

	}
	
	public int updateVotingStatus(int id) throws SQLException {
		pst3.setInt(1, id);
		int votingstatus=pst3.executeUpdate();
		if(votingstatus==1) {
			return 1;
		}
		return 0;
		
	}
	
	public void cleanUp() throws SQLException
	{
		if(pst1!=null) {
			pst1.close();
					}
		closeconnection();
		System.out.println("Clean up complete");
	}
	
}
