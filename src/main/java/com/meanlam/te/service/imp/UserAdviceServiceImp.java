package com.meanlam.te.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meanlam.te.dao.UserAdviceDao;
import com.meanlam.te.entity.UserAdvice;
import com.meanlam.te.service.UserAdviceService;

@Service
public class UserAdviceServiceImp implements UserAdviceService {

	@Autowired
	private UserAdviceDao userAdviceDao;
	
	@Override
	@Transactional
	public boolean insertUserAdvice(UserAdvice userAdvice) {

		if (userAdvice!=null)
		{
			try
			{
				int effectNum = userAdviceDao.insertAdvice(userAdvice);
				
				if (effectNum>0)
				{
					return true;
				}
				else {
					throw new RuntimeException("提交失败！");
				}
				
				
			} catch (Exception e)
			{
				throw new RuntimeException("提交失败！");
			}
		}
		
		else {		
		 throw new RuntimeException("未提交任何信息");			
		}
	
	}

}
