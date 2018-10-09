package com.carl.app.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.carl.app.dao.BaseDao;
import com.carl.app.pojo.User;

public class UserDaoImpl implements UserDao{

	@Override
	public int add(Connection connection, User user) throws Exception {
		PreparedStatement pstm = null;
		int updateRows = 0;
		if(connection!=null) {
			String sql = "insert into dawp_user(userName, userPassword,birthday, phone, email)"+
					"values(?,?,?,?,?)";
			Object[] params = {user.getUserName(),user.getUserPassword(),user.getBirthday(),user.getPhone(),user.getEmail()};
			updateRows = BaseDao.execute(connection, pstm, sql, params);
			BaseDao.closeResource(null, pstm, null);
		}
		return updateRows;
	}

	@Override
	public User getLoginUser(Connection connection, String userName) throws Exception {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		User user = null;
		if(null != connection) {
			String sql = "select * from dawp_user where userName=?";
			Object [] params = {userName};
			rs = BaseDao.execute(connection, pstm, rs, sql, params);
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("userName"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setBirthday(rs.getDate("birthday"));
				user.setPhone(rs.getString("userPhone"));
				user.setEmail(rs.getString("email"));
			}
			BaseDao.closeResource(null, pstm, rs);
		}
		return user;
	}

	@Override
	public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
