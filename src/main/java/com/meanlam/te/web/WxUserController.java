package com.meanlam.te.web;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.meanlam.te.entity.WxUserInfo;
import com.meanlam.te.service.WxUserService;
import com.meanlam.te.util.AesCbcUtil;
import com.meanlam.te.util.CommonUtils;
import com.meanlam.te.util.HttpRequest;

@RestController
@RequestMapping("/superadmin")
public class WxUserController {

	@Autowired
	private WxUserService wxUserService;
		
	/**
	 * 查询用户信息
	 * @param wxUserInfo
	 * @return
	 */
	
	@RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
	private Map<String, Object> getUserInfo(String uWxid)
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", wxUserService.getUserInfo(uWxid));
		return modelMap;
	}
	
	
	/**
	 * 往前微信端发送图片文件，HomeIndex需要的照片
	 * @param uWxid
	 * @return
	 */
	@RequestMapping(value = "/getStaticPhoto", method = RequestMethod.GET)
	private Map<String, Object> getStaticPhoto()
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String[] photoArray = new String[] {CommonUtils.MYURL+"hardworking.jpg",CommonUtils.MYURL+"happy.jpg",CommonUtils.MYURL+"thinking.jpg",CommonUtils.MYURL+"recommending.jpg"};
		modelMap.put("photos", photoArray);
	
		return modelMap;
	}
	
	/**
	 * 往前微信端发送图片文件，Help页面需要的图片
	 * @param uWxid
	 * @return
	 */
	@RequestMapping(value = "/getStaticPhotoOfHelp", method = RequestMethod.GET)
	private Map<String, Object> getStaticPhotoOfHelp()
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String[] photoArray = new String[] {CommonUtils.MYURL+"authorize.png",CommonUtils.MYURL+"select.png",CommonUtils.MYURL+"details.png",CommonUtils.MYURL+"comment.png",CommonUtils.MYURL+"sendEmail.png",CommonUtils.MYURL+"me.png"};
		modelMap.put("photosHelp", photoArray);	
		return modelMap;
	}
	/*
	 * 修改用户信息
	 * @param wxUserInfo
	 * @return
	 */
	@RequestMapping(value = "/modifyUserInfo", method = RequestMethod.POST)
	private Map<String, Object> modifyUserInfo(@RequestBody WxUserInfo wxUserInfo)
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", wxUserService.updateWxUserInfo(wxUserInfo));	
		return modelMap;
	}
	
	/*
	 * 添加一个用户信息
	 * @param wxUserInfo
	 * @return
	 */
	@RequestMapping(value = "/insertWxUser", method = RequestMethod.POST)
	private Map<String, Object> addAreaById(@RequestBody WxUserInfo wxUserInfo)
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", wxUserService.insertWxUser(wxUserInfo));
		return modelMap;
	}

	
	

	/**
	   * @Title: decodeUserInfo
	    * @Description: 解密用户敏感数据
	    * @param encryptedData 明文,加密数据
	     * @param iv   加密算法的初始向量
	     * @param code  用户允许登录后，回调内容会带上 code（有效期五分钟），开发者需要将 code 发送到开发者服务器后台，使用code 换取 session_key api，将 code 换成 openid 和 session_key
	     * @return
	 */
	@RequestMapping(value = "/decodeUserInfo",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> decodeUserInfo(String encryptedData, String iv, String code)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		// 登录凭证不能为空
		if (code == null || code.length() == 0) {
			map.put("status", 0);
			map.put("msg", "code 不能为空");
			return map;
		}
 
		// 小程序唯一标识 (在微信小程序管理后台获取)
		String wxspAppid = "wx8b7a09b5490be970";
		// 小程序的 app secret (在微信小程序管理后台获取)
		String wxspSecret = "1c31887865baf69c1ec2da5abfd72400";
		// 授权（必填）
		String grant_type = "authorization_code";
 
	/* 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid*/
		
		// 请求参数
		String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type="
				+ grant_type;
		// 发送请求
		String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
		
		// 解析相应内容（转换成json对象）
		JSONObject json = JSONObject.parseObject(sr);
		
		// 获取会话密钥（session_key）
		String session_key = json.get("session_key").toString();
		
		// 用户的唯一标识（openid）
//		String openid = (String) json.get("openid");
			
/*	  2、对encryptedData加密数据进行AES解密 */
		try {
			String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
			if (null != result && result.length() > 0) {
				map.put("status", 1);
				map.put("msg", "解密成功");
 
				JSONObject userInfoJSON = JSONObject.parseObject(result);
				Map<String,Object> userInfo = new HashMap<String,Object>();
				userInfo.put("openId", userInfoJSON.get("openId"));
				userInfo.put("nickName", userInfoJSON.get("nickName"));
				userInfo.put("gender", userInfoJSON.get("gender"));
				userInfo.put("city", userInfoJSON.get("city"));
				userInfo.put("province", userInfoJSON.get("province"));
				userInfo.put("country", userInfoJSON.get("country"));
				userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
				// 解密unionId & openId;
				userInfo.put("unionId", userInfoJSON.get("unionId"));								
				map.put("userInfo", userInfo);		
				
											
			} else {
				map.put("status", 0);
				map.put("msg", "解密失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	
}	  
