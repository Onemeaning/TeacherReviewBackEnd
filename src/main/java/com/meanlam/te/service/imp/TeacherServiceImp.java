package com.meanlam.te.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meanlam.te.dao.CommentDao;
import com.meanlam.te.dao.EmailsContentDao;
import com.meanlam.te.dao.TeacherDao;
import com.meanlam.te.dao.ThumbsUpCountsDao;
import com.meanlam.te.entity.Teacher;
import com.meanlam.te.service.TeacherService;

@Service
public class TeacherServiceImp implements TeacherService{

	@Autowired
	private TeacherDao teacherDao;
	
	@Autowired
	private EmailsContentDao emailsContentDao;
	
	@Autowired
	private ThumbsUpCountsDao thumbsUpCountsDao;
	
	@Autowired
	private CommentDao commnetDao;
	
	@Override
	@Transactional
	public List<Teacher> findByAffiliation(String affiliation) {
		
		String aString = "%" + affiliation + "%";
		return teacherDao.findByAffiliation(aString);
	}

	
	@Override
	@Transactional
	public Teacher findByTeacherId(String tId) {
		
		return teacherDao.findByTeacherId(tId);
	}

	
	@Override
	@Transactional
	public boolean addATeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public List<Teacher> listTopFiveTeacher(String affiliation) {
		
		return teacherDao.findTopFive("%"+affiliation+"%");
	}

	@Override
	@Transactional
	public boolean updateSupportCounts(Teacher teacher) {		
		if (teacher.gettId()!=null)
		{
			try
			{
				int effectNum = teacherDao.updateThumpUp(teacher);				
				if (effectNum > 0)
				{
					return true;
					
				} else
				{
					throw new RuntimeException("更新点赞数失败！");
				}
			} catch (Exception e)
			{
				throw new RuntimeException("更新点赞数失败！" + e.getMessage());
			}
		} else
		{
			throw new RuntimeException("更新失败，未知异常");
		}
	}

	@Override
	public Teacher getTeacherPhoto(String tAffiliation, String tName) {
		
		return  teacherDao.getTeacherPhoto(tAffiliation,tName);
	}

	@Override
	@Transactional
	public boolean updateTeacherInfo(Teacher t1) {
		
		if (t1.gettAffiliation()!=null && t1.gettName()!=null)
		{
			try
			{
				int effectNum = teacherDao.updateTid(t1);
				if (effectNum > 0)
				{
					return true;
					
				} else
				{
					throw new RuntimeException("更新老师ID成功！");
				}
			} catch (Exception e)
			{
				throw new RuntimeException("更新老师ID失败！" + e.getMessage());
			}
		} else
		{
			throw new RuntimeException("更新失败，未知异常");
		}
		
	}

	@Override
	@Transactional
	public boolean updateTeacherDetails(Teacher teacher) {
		
		if (teacher.gettId()!=null)
		{
			try
			{
				int effectNum = teacherDao.updateTeacherDetails(teacher);
				if (effectNum > 0)
				{
					return true;
					
				} else
				{
					throw new RuntimeException("更新老师信息失败！");
				}
			} catch (Exception e)
			{
				throw new RuntimeException("更新老师信息失败！" + e.getMessage());
			}
		} else
		{
			throw new RuntimeException("更新失败，未知异常");
		}
	}

	@Override
	@Transactional
	public boolean updateAllDatabaseTeacherId(String tId, String oldteacherId) {
		
		if ( tId != null && oldteacherId != null)
		{
			try
			{
				emailsContentDao.updateEmailsId(tId,oldteacherId);
				thumbsUpCountsDao.updateThumbsId(tId,oldteacherId);
				commnetDao.updateCommnetId(tId,oldteacherId);
				return true;
				
			} catch (Exception e)
			{
				System.out.println(e.getMessage());
				throw new RuntimeException("更新老师信息失败！" + e.getMessage());
			}
		} else
		{
			throw new RuntimeException("更新失败，未知异常");
		}
			
	}

}
