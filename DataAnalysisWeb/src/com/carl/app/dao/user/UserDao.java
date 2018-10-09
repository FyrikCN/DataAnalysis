package com.carl.app.dao.user;

import java.sql.Connection;
import java.util.List;

import com.carl.app.pojo.User;

public interface UserDao {
	/**
	 * Add user Information
	 * @param connection
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int add(Connection connection,User user)throws Exception;

	/**
	 * Get user from userName
	 * @param connection
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public User getLoginUser(Connection connection,String userName)throws Exception;

	/**
	 * condition query-userList
	 * @param connection
	 * @param userName
	 * @param userRole
	 * @return
	 * @throws Exception
	 */
	public List<User> getUserList(Connection connection,String userName,int userRole,int currentPageNo, int pageSize)throws Exception;
	/**
	 * condition query-form record
	 * @param connection
	 * @param userName
	 * @param userRole
	 * @return
	 * @throws Exception
	 */
}
