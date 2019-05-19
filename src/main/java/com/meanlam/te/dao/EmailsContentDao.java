package com.meanlam.te.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.meanlam.te.entity.EmailsContent;

public interface EmailsContentDao {

	public List<EmailsContent> findById(String id);
	public int updateById(EmailsContent emailsContent);
	public int insertData(EmailsContent emailsContent);
	public int deleteById(EmailsContent emailsContent);
	public int deleteAll(String toId);
	
	//更具就的ID更换为新的老师新的老师ID
	public int updateEmailsId(@Param("newId") String tId, @Param("oldId")String oldteacherId);
	
	//根据源目ID查询历史聊天记录
	public List<EmailsContent> findHistoryRecord(@Param("fromId") String fromId, @Param("toId")String toId);
}
