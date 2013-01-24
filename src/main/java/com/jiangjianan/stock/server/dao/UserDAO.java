package com.jiangjianan.stock.server.dao;

import com.jiangjianan.stock.server.object.UserDO;

public interface UserDAO {

	public UserDO getUserById(Long id);

	public void insertUser(UserDO userDO);

	public void updateUser(UserDO userDO);

	public void deleteUserById(Long id);
	
	public UserDO getUserByName(String name);
}
