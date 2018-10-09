package com.carl.app.user;

//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
import com.carl.app.dao.BaseDao;
import com.carl.app.dao.user.UserDao;
import com.carl.app.dao.user.UserDaoImpl;
import com.carl.app.pojo.User;

class UserDaoTest {
	private UserDao userDao=new UserDaoImpl();
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Before
	public void setUp() {
		
	}
	//Add user testing
	@Test
	public void testAdd() {
		
		Connection connection = null;
		int result = 0;
		try {
		User user= new User();
		user.setUserName("TestingUser001");
		user.setUserPassword("test1234");
		user.setEmail("example123@www.com");
		user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1996-08-10"));
		user.setPhone("123344565");
		connection =BaseDao.getConnection();
		connection.setAutoCommit(false);
		result = userDao.add(connection, user);
		connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			result=0;
		}finally {
			BaseDao.closeResource(connection, null, null);
		}
	}
	//Test get user list
	@Test
	public void testGetUserList(){
		Connection connection=null;
		connection=BaseDao.getConnection();
		List<User> users=new ArrayList<User>();
		try {
			users=userDao.getUserList(connection, null, 0, 1, 5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.closeResource(connection, null, null);
		}
		for (User user : users) {
			System.out.println(user.getId()+"\t"+user.getUserName()+"\t"+user.getUserName());
		}
	}

}
