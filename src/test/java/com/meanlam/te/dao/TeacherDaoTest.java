package com.meanlam.te.dao;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.meanlam.te.entity.Teacher;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherDaoTest {

	@Autowired
	private TeacherDao teacherDao;
	
	@Test
	@Ignore
	public void testFindByAffiliation() {
		List<Teacher> listTeacher = teacherDao.findByAffiliation("湖南大学");
		assertEquals(3, listTeacher.size());// 之所以是3，是因为我们事先在数据库中存储了两个数据。
	}

	@Test
	@Ignore
	public void testFindByTeacherId() {
		String name = teacherDao.findByTeacherId("1").gettName();
		assertEquals("蒋老师",name );
	}

	@Test
	@Ignore
	public void testAddATeacher() {
		Teacher teacher = new Teacher();
		teacher.settId("4");;
		teacher.settName("sds");
		teacher.settEmail("111");
		teacher.settResearchInterest("dhsd");
		assertEquals(1,teacherDao.addATeacher(teacher));
		
	}
	@Test
	@Ignore
	public void testFindTopFive()
	{
		List<Teacher> list = teacherDao.findTopFive("");
		assertEquals(2, list.size());
	}

}
