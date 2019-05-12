package com.meanlam.te.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.meanlam.te.entity.Teacher;

public interface TeacherDao {	
	
	/**
	 * 根据点赞数选择前五名，用于在首页展示
	 * @return
	 */
	List<Teacher> findTopFive(String affiliation);
	
	
	/**
	 * 根据老师所属单位模糊查询
	 * @param affiliation 老师所属单位
	 * @return 老是所属系的一系列老师的集合
	 */
	 List<Teacher> findByAffiliation(String affiliation);
	/**
	 * 根据老师的ID进行查询，一般为点击老师的简介，进入到老师的详细介绍的界面
	 * @param tId
	 * @return 一个老师的对象
	 */
	 
	Teacher findByTeacherId(String tId);
	
	/**
	 * 向数据库更新你的点赞数
	 * @param teacher
	 * @return
	 */
	int updateThumpUp(Teacher teacher);
	
	
	
	/**
	 * 用于让学生往数据库中添加老师的数据
	 * @param teacher
	 * @return
	 */
		
	 int addATeacher(Teacher teacher);

	 /**
	  * 查询老师照片的地址，
	  * @param tAffiliation 老师所在单位
	  * @param tName 老师的名字
	  * @return
	  */
	Teacher getTeacherPhoto(String tAffiliation, String tName);

	/**
	 *   更新老师的ID
	 * @param t1
	 * @return
	 */
	int updateTid(Teacher t1);

	/**
	 * 更新老师的信息
	 * @param teacher
	 * @return
	 */
	int updateTeacherDetails(Teacher teacher);
}
