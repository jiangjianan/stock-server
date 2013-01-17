package com.jiangjianan.stock.server.service;

import com.jiangjianan.stock.server.common.service.Result;
import com.jiangjianan.stock.server.object.TokenDO;

public interface StockInfoService {
	public Result<TokenDO> relogin(String code);
}
