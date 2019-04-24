package com.meanlam.te.service;

import java.util.List;

import com.meanlam.te.entity.EmailsContent;

public interface EmailsContentService {

	/**
	 * 根据自己的ID查询所有的邮件
	 * @param toId
	 * @return
	 */
	public List<EmailsContent> getAllEmails(String toId);
	
	/**
	 *     更新邮件查看状态
	 * @param toId
	 * @return
	 */
	public boolean emailsChecked(EmailsContent emailsContent);
	
	/**
	 * 写一封邮件
	 * @param emailsContent
	 * @return
	 */
	public boolean writeEmail(EmailsContent emailsContent);
	
	/**
	 * 删除指定人发来的邮件
	 * @param emailsContent
	 */
	public boolean deleteById(EmailsContent emailsContent);
	
	/**
	 *  删除所有邮件
	 * @param toId
	 */
	public boolean deleteAll(String toId);
	
	/**
	 * 未查看邮件的数量
	 * @param toId
	 * @return
	 */
	public int uncheckedEmailsNum(String toId);
	
	
}
