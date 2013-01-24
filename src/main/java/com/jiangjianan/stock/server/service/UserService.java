package com.jiangjianan.stock.server.service;

import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.object.UserDO;

public interface UserService {
	public Result<UserDO> getUserByName(String user);

	public Result<Boolean> insertUser(UserDO userDO);

	public Result<Boolean> updateUser(UserDO userDO);
}
