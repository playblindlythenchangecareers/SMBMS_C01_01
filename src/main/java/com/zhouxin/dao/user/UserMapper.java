package com.zhouxin.dao.user;

import com.zhouxin.pojo.Provider;
import com.zhouxin.pojo.User;

import java.util.ArrayList;

public interface UserMapper {
	int count();
	ArrayList<Provider> getProvideList();
	ArrayList<User> getUserList();
}
