package com.meanlam.te.service;

import java.util.List;

import com.meanlam.te.entity.Teacher;

public interface TeacherService {
	/**
	 * 根据老师所属单位模糊查询
	 * @param affiliation 老师所属单位
	 * @return 老是所属系的一系列老师的集合
	 */
	public List<Teacher> findByAffiliation(String affiliation);
	/**
	 * 根据老师的ID进行查询，一般为点击老师的简介，进入到老师的详细介绍的界面
	 * @param tId
	 * @return 一个老师的对象
	 */
	public Teacher findByTeacherId(String tId);
	/**
	 * 用于让学生往数据库中添加老师的数据
	 * @param teacher
	 * @return
	 */
	public boolean addATeacher(Teacher teacher);
	
	/**
	 * 每日推荐的前十名的老师
	 * @return
	 */
	public List<Teacher> listTopFiveTeacher(String affiliation);
	
	/**
	 * 更新点赞数
	 * @param tThumpUpCounts
	 * @return
	 */
	public boolean updateSupportCounts(Teacher teacher);
	
	/**
	 *    根据老师的单位以及名字进行获取老师的照片信息
	 * @param tId
	 * @return 一个老师的对象
	 */
	public Teacher getTeacherPhoto(String tAffiliation,String tName);
	
	/**
	 *  将老师ID与微信OPENID绑定起来
	 * @param t1
	 */
	public boolean updateTeacherInfo(Teacher t1);
	
	/**
	 * 更新老师的信息；
	 * @param teacher
	 * @return
	 */
	public boolean updateTeacherDetails(Teacher teacher);
	
	/**
	 * 更新所有数据中老师的旧ID为新的老师微信的OPEN ID；
	 * @param teacher
	 * @return
	 */
	public boolean updateAllDatabaseTeacherId(String tId, String oldteacherId);
		
}
