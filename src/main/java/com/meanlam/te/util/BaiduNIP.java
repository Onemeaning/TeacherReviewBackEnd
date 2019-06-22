package com.meanlam.te.util;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.nlp.ESimnetType;

public class BaiduNIP {
	/**
	 * 用于自然语言处理的类，AipNlp是自然语言处理的Java客户端，为使用自然语言处理的开发人员提供了一系列的交互方法。
	  用户可以参考如下代码新建一个AipNlp,初始化完成后建议单例使用,避免重复获取access_token：
	 */	
	//设置APPID/AK/SK
    public static final String APP_ID = "16600976";
    public static final String API_KEY = "z79X0dtYW6BKUy6FkIG8rlg9";
    public static final String SECRET_KEY = "nPN1LppL3t6sa2H8fPNUduudDYLILpEF";

    private static AipNlp client = null;
    private static AipNlp getAipNlp()
    {
    	if (client == null)
		{
    		client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);
		}
    	
    	return client;
    }
    public static int sentimentAnalysis(String text) {
    	
        // 初始化一个AipNlp
        AipNlp client = getAipNlp();
        
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        
        // 传入可选参数调用接口
        HashMap<String, Object> options = new HashMap<String, Object>();
        // 情感倾向分析
        JSONObject res = client.sentimentClassify(text, options);    
        JSONArray jsonArray = res.getJSONArray("items");

        JSONObject item = jsonArray.getJSONObject(0);
        int sentiment = Integer.parseInt(item.get("sentiment").toString());
        double confidence = Double.parseDouble(item.get("confidence").toString());
        double negative_prob = Double.parseDouble(item.get("negative_prob").toString());
        
        if (confidence < 0.5)
		{
        	if (negative_prob > 0.6)
			{
        		return 0;
			}
        	else 
        	{
				return 1;
			}  	
		}
  
        return sentiment;
        
    }
    
//    public static void main(String[] args) {
//    	
//    	String text = "这个老师不负责任";
//    	// 传入可选参数调用接口
//        HashMap<String, Object> options = new HashMap<String, Object>();
//        
//        // 初始化一个AipNlp
//        AipNlp client = getAipNlp();
//        
//
//        // 获取美食评论情感属性
//        JSONObject response = client.commentTag(text, ESimnetType.FOOD, options);
//        System.out.println(response.toString());
//
//	}
    
}
