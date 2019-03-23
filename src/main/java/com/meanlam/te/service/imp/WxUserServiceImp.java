package com.meanlam.te.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meanlam.te.dao.WxUserDao;
import com.meanlam.te.entity.WxUserInfo;
import com.meanlam.te.service.WxUserService;

@Service
public class WxUserServiceImp implements WxUserService {

	@Autowired
	private WxUserDao wxUserDao;

	@Transactional
	@Override
	public boolean insertWxUser(WxUserInfo wxUserInfo) {
		if (wxUserInfo.getuWxid() != null && !"".equals(wxUserInfo.getuWxid()))
		{
			try
			{
				int effectNum = wxUserDao.insertWxUser(wxUserInfo);
				if (effectNum > 0)
				{
					return true;
				} else
				{
					throw new RuntimeException("插入个人信息失败！");
				}
			} catch (Exception e)
			{
				throw new RuntimeException("插入个人信息失败:" + e.getMessage());
			}
		} else
		{
			throw new RuntimeException("插入个人信息不能为空！");
		}
	}

}
