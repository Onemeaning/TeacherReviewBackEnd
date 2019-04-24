package com.meanlam.te.dao;


import com.meanlam.te.entity.WxUserInfo;

public interface WxUserDao {

	int insertWxUser(WxUserInfo wxUserInfo);
	WxUserInfo queryUserInfo(String uWxid);
	int updateWxUserInfo(WxUserInfo wxUserInfo);
}
