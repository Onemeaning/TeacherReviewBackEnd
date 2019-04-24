package com.meanlam.te.dao;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.meanlam.te.entity.UserAdvice;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAdviceDaoTest {

	@Autowired
	private UserAdviceDao userAdviceDao;
	
	@Ignore
	public void testInsertAdvice() {
	 UserAdvice userAdvice = new UserAdvice();
        userAdvice.setUserId("111");
        userAdvice.setAdviceContent("1111");
        userAdvice.setAdviceTime("12212");
        userAdvice.setAdviceType("1111");
        
        userAdviceDao.insertAdvice(userAdvice);
}

}
