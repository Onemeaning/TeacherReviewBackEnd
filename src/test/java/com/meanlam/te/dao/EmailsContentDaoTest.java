package com.meanlam.te.dao;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.meanlam.te.entity.EmailsContent;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailsContentDaoTest {
	
	@Autowired
	private EmailsContentDao emailsContestDao;
	
	
	@Ignore
	public void testFindById() {
		
		System.out.println(emailsContestDao.findById("4").toString());
	}

	@Ignore
	public void testUpdateById() {
		EmailsContent emailsContest = new EmailsContent();
		emailsContest.setFromId("2222");
		emailsContest.setFromIdImage("2");
		emailsContest.setFromIdNickName("3");
		emailsContest.setToId("4");
		emailsContest.setChecked(false);
		emailsContest.setSendTime("6");
		emailsContest.setEmailContent("dsdsds");
		emailsContest.setFile(new byte[] {0,1});
		emailsContestDao.updateById(emailsContest);
	}

	@Ignore
	public void testInsertData() {
		
		EmailsContent emailsContest = new EmailsContent();
		emailsContest.setFromId("2222");
		emailsContest.setFromIdImage("2");
		emailsContest.setFromIdNickName("3");
		emailsContest.setToId("4");
		emailsContest.setChecked(false);
		emailsContest.setSendTime("6");
		emailsContest.setEmailContent("dsdsds");
		emailsContest.setFile(new byte[] {0,1});
		emailsContestDao.insertData(emailsContest);
		
		
		
	}

	@Ignore
	public void testDeleteById() {
		EmailsContent emailsContest = new EmailsContent();
		emailsContest.setFromId("1");
		emailsContest.setToId("4");
		emailsContest.setSendTime("6");

		emailsContestDao.deleteById(emailsContest);
	}

	@Ignore
	public void testDeleteAll() {
		emailsContestDao.deleteAll("4");
	}

}
