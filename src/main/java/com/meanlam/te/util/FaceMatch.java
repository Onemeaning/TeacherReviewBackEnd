package com.meanlam.te.util;

import org.json.JSONException;
import org.json.JSONObject;
import com.meanlam.te.util.Base64Util;
import com.meanlam.te.util.FileUtil;
import com.meanlam.te.util.GsonUtils;
import com.meanlam.te.util.HttpUtil;
import java.util.*;
 
/**
 * 人脸对比 http://ai.baidu.com/docs#/Face-Match-V3/top 需改动【本地文件1地址】、【本地文件2地址】、（从AuthService类获得）【调用鉴权接口获取的token】
 */
public class FaceMatch {
 
/**
 * 重要提示代码中所需工具类
 * FileUtil,Base64Util,HttpUtil,GsonUtils请从
 * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
 * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
 * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
 * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
 * 下载
 */
public static final String COMPARE_SUCCESS = "3";//匹配成功
public static final String COMPARE_FAIL = "2";//匹配失败，相似度不够
public static final String NOT_LIFE = "1";//不是活体照片	
	
	/**
	 * 这个方法将会用于比对人脸图像是否相同
	 * @param args
	 */
	public static Map<String, String> comparePhoto(String imgPath1,String imgPath2) {
    	
		Map<String, String> judgeResult = new HashMap<>();
		
        String ak = "j4u5rLYrFabUxRiKl7AqctRo";
        String sk = "5azlZnzqMagyY4LyaTGozX0vVX7OgC9s";
                  
        String result = FaceMatch.match(ak, sk, imgPath1, imgPath2);
        
        //下面是处理非活体的检测的
        int index = result.indexOf("result");
        String newString = result.substring(index);
        if (newString.indexOf("null")!=-1)
		{
        	judgeResult.put(NOT_LIFE, "非活体照片，请使用自拍照片！");
			return judgeResult;//非活体直接返回;
		}
        
        //是活体，下面分析匹配情况;
        try {
        	
        	JSONObject jsonObj = new JSONObject(result).getJSONObject("result");         	
            String score=(jsonObj).get("score").toString();   
           
            // 阈值为80，高于80分判断为同一人
            if(Double.parseDouble(score) >= 80)
            {
            	judgeResult.put(COMPARE_SUCCESS, "匹配得分："+score+",判定为同一个人！");
            }
            else {
            	judgeResult.put(COMPARE_FAIL, "匹配得分："+score+",认为不是同一个人");
			}  
            
        } catch (JSONException e) {
            e.printStackTrace();
        }
        
        return judgeResult;
    }
	
	
	public static String match(String ak, String sk, String imgPath1, String imgPath2) {
        // 请求url
    	
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/match";
        try {
        	
            // 【本地文件1地址】
            byte[] bytes1 = FileUtil.readFileByBytes(imgPath1);
            // 【本地文件2地址】
            byte[] bytes2 = FileUtil.readFileByBytes(imgPath2);

            String image1 = Base64Util.encode(bytes1);
            String image2 = Base64Util.encode(bytes2);
           
            List<Map<String, Object>> images = new ArrayList<>();
            
            Map<String, Object> map1 = new HashMap<>();
            map1.put("image", image1);
            map1.put("image_type", "BASE64");
            map1.put("face_type", "IDCARD");
            map1.put("quality_control", "LOW");
            map1.put("liveness_control", "NONE");
 
            Map<String, Object> map2 = new HashMap<>();
            map2.put("image", image2);
            map2.put("image_type", "BASE64");
            map2.put("face_type", "LIVE");
            map2.put("quality_control", "LOW");
            map2.put("liveness_control", "NORMAL");
 
            images.add(map1);
            images.add(map2);

            String param = GsonUtils.toJson(images);
               
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            // 【调用鉴权接口获取的token】
            String accessToken = AuthService.getAuth(ak, sk);
 
            String result = HttpUtil.post(url, accessToken, "application/json", param);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
 
    
}
