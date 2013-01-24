package com.jiangjianan.stock.server.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.jiangjianan.stock.server.dao.UserDAO;
import com.jiangjianan.stock.server.object.UserDO;

@SuppressWarnings("deprecation")
public class UserDAOImpl extends SqlMapClientDaoSupport implements UserDAO {

	@Override
	public UserDO getUserById(Long id) {
		return (UserDO) this.getSqlMapClientTemplate().queryForObject(
				"userDAO.getUserById", id);
	}

	@Override
	public void insertUser(UserDO userDO) {
		this.getSqlMapClientTemplate().insert("userDAO.insertUser", userDO);
	}

	@Override
	public void updateUser(UserDO userDO) {
		this.getSqlMapClientTemplate().update("userDAO.updateUser", userDO);
	}

	@Override
	public void deleteUserById(Long id) {
		this.getSqlMapClientTemplate().delete("userDAO.deleteUserById", id);
	}

	@Override
	public UserDO getUserByName(String name) {
		return (UserDO) this.getSqlMapClientTemplate().queryForObject(
				"userDAO.getUserByName", name);
	}

}
