package com.meanlam.te.dao;

import java.util.List;

import com.meanlam.te.entity.WxUserInfo;

public interface WxUserDao {

	int insertWxUser(WxUserInfo wxUserInfo);
	List<WxUserInfo> queryUserInfo();
}
