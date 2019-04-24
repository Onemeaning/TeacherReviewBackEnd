package com.meanlam.te.service.imp;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meanlam.te.dao.EmailsContentDao;
import com.meanlam.te.entity.EmailsContent;
import com.meanlam.te.service.EmailsContentService;

@Service
public class EmailsContentServiceImp implements EmailsContentService {
	
	@Autowired
	private EmailsContentDao emailsContentDao; 
	
	@Override
	public List<EmailsContent> getAllEmails(String toId) {	
		List<EmailsContent> emailsList = new ArrayList<EmailsContent>();		
		emailsList =  emailsContentDao.findById(toId);
		return emailsList;
	}

	@Override
	@Transactional
	public boolean emailsChecked(EmailsContent emailsContent) {
		
		if (emailsContent!=null)
		{
			try
			{
				int effectNum = emailsContentDao.updateById(emailsContent);
				if (effectNum>0)
				{
					return true;
				}
				else
				{
					throw new RuntimeException("邮件查看状态更改失败");
				}
			} catch (Exception e)
			{
				throw new RuntimeException("邮件查看状态更改失败");
			}
			
		}
		else
		{
			throw new RuntimeException("传入的ID不能为空！");
		}
		
	}

	@Override
	@Transactional
	public boolean writeEmail(EmailsContent emailsContent) {
		
		if (emailsContent!=null)
		{
			if (emailsContent.getFromId()==null)
			{
				throw new RuntimeException("发件人的唯一标识不能为空");
			}
			
			if (emailsContent.getToId()==null)
			{
				throw new RuntimeException("收件人的账号不能为空");
			}
			
			if (emailsContent.getSendTime()==null)
			{
				throw new RuntimeException("邮件时间不能为空");
			}
			
			try
			{
				int effectNum = emailsContentDao.insertData(emailsContent);
				if (effectNum>0)
				{				
					return true;
				}
				else
				{
					throw new RuntimeException("邮件发送失败！");
				}
			} catch (Exception e)
			{
				throw new RuntimeException("邮件发送失败！");
			}
			
		}
		else
		{
			throw new RuntimeException("邮件对象为空");
		}
		
		
	}

	@Override
	@Transactional
	public boolean deleteById(EmailsContent emailsContent) {
		if (emailsContent!=null)
		{
			if (emailsContent.getFromId()==null)
			{
				throw new RuntimeException("发件人的唯一标识不能为空");
			}
			
			if (emailsContent.getToId()==null)
			{
				throw new RuntimeException("收件人的账号不能为空");
			}
			
			if (emailsContent.getSendTime()==null)
			{
				throw new RuntimeException("邮件时间不能为空");
			}
			
			try
			{
				int effectNum = emailsContentDao.deleteById(emailsContent);
				if (effectNum>0)
				{
					return true;
				}
				else
				{
					throw new RuntimeException("邮件删除失败！");
				}
			} catch (Exception e)
			{
				throw new RuntimeException("邮件删除失败！");
			}
			
		}
		else
		{
			throw new RuntimeException("邮件对象为空");
		}
		

	}

	@Override
	public boolean deleteAll(String toId) {
		if (toId!=null)
		{
			try
			{
				int effectNum = emailsContentDao.deleteAll(toId);
				if (effectNum>0)
				{
					return true;
				}
				else
				{
					throw new RuntimeException("删除所有邮件失败");
				}
			} catch (Exception e)
			{
				throw new RuntimeException("删除所有邮件失败");
			}
			
		}
		else
		{
			throw new RuntimeException("传入的ID不能为空！");
		}

	}


	public int uncheckedEmailsNum(String toId) {
		
		List<EmailsContent> emailsList = emailsContentDao.findById(toId);
		int num = 0;
		for (EmailsContent emailsContent : emailsList)
		{
			if (!emailsContent.isChecked())
			{
				num++;
			}
		}
				
		return num;
	}

}
