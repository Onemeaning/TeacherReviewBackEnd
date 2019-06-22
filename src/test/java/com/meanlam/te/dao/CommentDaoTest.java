package com.meanlam.te.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.meanlam.te.entity.Comment;
import com.meanlam.te.entity.CommentType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentDaoTest {

	@Autowired
	private CommentDao cmmentDao;
	
	@Test
	@Ignore
	public void testQuaryComment() {
		List<Comment> commmentList = cmmentDao.quaryComment("1554554384");
		assertEquals(2, commmentList.size());// 之所以是2，是因为我们事先在数据库中存储了两个数据。
	}
	
	@Test
	@Ignore
	public void testQueryCommentType()
	{	
		List<CommentType> commmentList = cmmentDao.getCommentTypes("1554554384");
		System.out.println(commmentList.toString());
	}
	
	@Test
	@Ignore
	public void testInsertComment() {
		Comment comment = new Comment();
		comment.setSourceId("wx103");
		comment.setuComments("老师很不错");
		comment.settId("t10001");
		comment.setuInsertTime("2019-03-19 20:19:20");
		comment.setuNickName("小红");
		comment.setuPhoto("111");
		assertEquals(1,cmmentDao.insertComment(comment));
		
	}

	@Test
	@Ignore
	public void testDeleteComment() {
		Comment comment = new Comment();
		comment.setSourceId("oKnF45PKGIEW1BV3EAw9CBx3FZhc");
		comment.setuInsertTime("2019-03-21 13:51:20");
		assertEquals(1,	cmmentDao.deleteComment(comment));
	}

}
