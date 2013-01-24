package com.jiangjianan.stock.server.service.impl;

import java.util.Date;

import com.jiangjianan.stock.server.common.service.BaseService;
import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.common.service.ResultSupport;
import com.jiangjianan.stock.server.dao.UserDAO;
import com.jiangjianan.stock.server.object.UserDO;
import com.jiangjianan.stock.server.service.UserService;

public class UserServiceImpl extends BaseService implements UserService {
	private UserDAO userDAO;

	@Override
	public Result<Boolean> insertUser(UserDO userDO) {
		Result<Boolean> result = new ResultSupport<Boolean>();
		try {
			userDAO.insertUser(userDO);
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error("UserServiceImpl.insertUser", e);
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public Result<Boolean> updateUser(UserDO userDO) {
		Result<Boolean> result = new ResultSupport<Boolean>();
		try {
			UserDO dbUser = userDAO.getUserById(userDO.getId());
			if (dbUser == null) {
				result.setSuccess(false);
			} else {
				String password = userDO.getPassword();
				if (password != null) {
					userDO.setPassword(password);
				}
				String email = userDO.getEmail();
				if (email != null) {
					userDO.setEmail(email);
				}
				Date login = userDO.getLogin();
				if (login != null) {
					userDO.setLogin(login);
				}
				userDAO.updateUser(userDO);
				result.setSuccess(true);
			}
		} catch (Exception e) {
			logger.error("UserServiceImpl.updateUser", e);
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public Result<UserDO> getUserByName(String name) {
		Result<UserDO> result = new ResultSupport<UserDO>();
		try {
			UserDO userDO = userDAO.getUserByName(name);
			if (userDO != null) {
				result.setDefaultModel(userDO);
				result.setSuccess(true);
			} else {
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("UserServiceImpl.getUserByName", e);
			result.setSuccess(false);
		}
		return result;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
