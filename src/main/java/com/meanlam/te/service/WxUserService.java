package com.meanlam.te.service;

import com.meanlam.te.entity.WxUserInfo;

public interface WxUserService {

	boolean insertWxUser(WxUserInfo wxUserInfo);
	boolean updateWxUserInfo(WxUserInfo wxUserInfo);
	WxUserInfo getUserInfo(String uWxid);
}
