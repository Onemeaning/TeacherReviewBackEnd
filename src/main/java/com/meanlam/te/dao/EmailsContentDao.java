package com.meanlam.te.dao;



import java.util.List;

import com.meanlam.te.entity.EmailsContent;

public interface EmailsContentDao {

	public List<EmailsContent> findById(String id);
	public int updateById(EmailsContent emailsContent);
	public int insertData(EmailsContent emailsContent);
	public int deleteById(EmailsContent emailsContent);
	public int deleteAll(String toId);
}
