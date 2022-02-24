package com.zhouxin;

import com.zhouxin.pojo.Provider;
import com.zhouxin.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperTest {

	private final Logger logger = Logger.getLogger(UserMapperTest.class);

	@Before
	public void setUp() throws Exception {
		logger.debug("测试开始");
	}

	@After
	public void setEnd() throws Exception {
		logger.debug("测试结束");
	}

	@Test
	public void test() {
		String resource = "mybatis-config.xml";
		int count = 0;
		SqlSession sqlSession = null;
		try {
			//1 获取mybatis-config.xml的输入流
			InputStream is = Resources.getResourceAsStream(resource);
			//2 创建SqlSessionFactory对象，完成对配置文件的读取
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			//3 创建sqlSession
			sqlSession = factory.openSession();
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			count = sqlSession.selectOne("com.zhouxin.dao.user.UserMapper.count");
			logger.debug("UserMapperTest count---> " + count);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			assert sqlSession != null;
			sqlSession.close();
		}
	}

	@Test
	public void testGetUserList() {
		String resource = "mybatis-config.xml";
		SqlSession sqlSession = null;
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			sqlSession = factory.openSession();
			List<User> users = sqlSession.selectList("com.zhouxin.dao.user.UserMapper.getUserList");
			for (User user : users
			) {
				logger.debug(user.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			assert sqlSession != null;
			sqlSession.close();
		}
	}



	@Test
	public void testGetProvideList() {
		String resource = "mybatis-config.xml";
		SqlSession sqlSession = null;
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			sqlSession = factory.openSession();
			List<Provider> providers = sqlSession.selectList("com.zhouxin.dao.user.UserMapper.getProvideList");
			for (Provider provider : providers
			) {
				logger.debug(provider.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			assert sqlSession != null;
			sqlSession.close();
		}
	}


}
