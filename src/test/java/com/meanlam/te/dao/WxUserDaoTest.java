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
	@Test
	@Ignore
	public void testUpdateWxUserInfo()
	{
		WxUserInfo wxUserInfo = new WxUserInfo();
		wxUserInfo.setuWxid("oKnF45PKGIEW1BV3EAw9CBx3FZhc");
		wxUserInfo.setuSchool("1213");
		wxUserInfo.setuNickname("meanlam");
		wxUserInfo.setuCollege("11");
		wxUserInfo.setuDepartment("212");
		wxUserInfo.setuStudentId("sss");
		wxUserInfo.setuTeacherName("11");
		int effectNum = wxUserDao.updateWxUserInfo(wxUserInfo);
		assertEquals(1, effectNum);
	}
	
}
