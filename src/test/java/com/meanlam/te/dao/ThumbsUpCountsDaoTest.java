package com.meanlam.te.dao;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.meanlam.te.entity.ThumbsCountsResult;
import com.meanlam.te.entity.ThumbsUpCounts;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThumbsUpCountsDaoTest {

	@Autowired
	private ThumbsUpCountsDao thumbsUpCountsDao;
	
	@Test
	@Ignore
	public void testDeleteCommentSupportCounts()
	{
		int num = thumbsUpCountsDao.deleteCommentSupportCounts("oKnF45PKGIEW1BV3EAw9CBx3FZhc", "oKnF45PKGIEW1BV3EAw9CBx3FZhc2019-03-22 10:47:58");
		assertEquals(2,num);			
	
	}
	
	@Test
	@Ignore
	public void testFindRecords() {
	ThumbsUpCounts tCounts=	thumbsUpCountsDao.findRecords("oKnF45PKGIEW1BV3EAw9CBx3FZhc", "1");
	assertEquals(null,tCounts);		
	}

	
	@Test
	@Ignore
	public void testGetDestIdWithCounts()
	{
		String teacherUniqueId = "1";
		List<ThumbsCountsResult> list = new ArrayList<ThumbsCountsResult>();
		list = thumbsUpCountsDao.getDestIdWithCounts(teacherUniqueId);
		System.out.println(list);		
	}
	
	

	@Test
	@Ignore
	public void testFindRecordsCounts() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testInsertCounts() {
		ThumbsUpCounts thumbsUpCounts = new ThumbsUpCounts();
		thumbsUpCounts.setSourceId("oKnF45PKGIEW1BV3EAw9CBx3FZhc");
		thumbsUpCounts.setDestId("1");
		thumbsUpCounts.setThumpsUpTime(new BigInteger("111111111111"));
		assertEquals(1, thumbsUpCountsDao.insertCounts(thumbsUpCounts));	
	}

	@Test
	@Ignore
	public void testDeleteThumbsUpCounts() {
		fail("Not yet implemented");
	}

}
