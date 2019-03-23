package com.meanlam.te.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.meanlam.te.entity.WxUserInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WxUserDaoTest {

	@Autowired
	private WxUserDao wxUserDao;

	@Test
	@Ignore
	public void tesInsertWxUser() {
		WxUserInfo wxUserInfo = new WxUserInfo();
		wxUserInfo.setuWxid("2");
		wxUserInfo.setuPhoto("11111");
		wxUserInfo.setuNickname("meanlam");
		wxUserInfo.setuCity("chansg");
		wxUserInfo.setuCountry("ds");
		wxUserInfo.setuProvince("ds");
		wxUserInfo.setuGender("sdnis");
		int effectNum = wxUserDao.insertWxUser(wxUserInfo);
		assertEquals(1, effectNum);
	}

}
