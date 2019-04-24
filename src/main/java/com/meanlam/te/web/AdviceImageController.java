package com.meanlam.te.web;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.meanlam.te.entity.UserAdvice;
import com.meanlam.te.service.UserAdviceService;

@RestController
@RequestMapping("superadmin")
public class AdviceImageController {
 
	@Autowired
	private UserAdviceService UserAdviceService;


    /**
     * @param request
     * @param file
     * @return 上传成功返回“success”，上传失败返回“error”
     * @throws IOException
     */
	@ResponseBody
    @RequestMapping("/advice")
    public String upload(HttpServletRequest request, @RequestParam(value = "advicePhoto", required = false) MultipartFile[] files) throws IOException {     		
        request.setCharacterEncoding("UTF-8");
        
        //获取表单的内容
        String userId = request.getParameter("userId");
        String adviceTime = request.getParameter("adviceTime");
        String adviceType = request.getParameter("adviceType");
        String adviceContent = request.getParameter("adviceContent"); 
        
        System.out.println(userId+adviceTime+adviceType+adviceContent);
        UserAdvice userAdvice = new UserAdvice();
        userAdvice.setUserId(userId);
        userAdvice.setAdviceContent(adviceContent);
        userAdvice.setAdviceTime(adviceTime);
        userAdvice.setAdviceType(adviceType);
        
        //处理多个图片文件
        if(files != null && files.length > 0) {
        	
        	for (MultipartFile multipartFile : files)
			{						
	            String fileName = multipartFile.getOriginalFilename();
	            String type = null;
	            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;        
	            if (type != null)
	            {
	            	if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                  
                    //获取跟目录             	
                	String urlPath = ResourceUtils.getURL("classpath:").getPath();              	
                    File path = new File(URLDecoder.decode(urlPath, "UTF-8"));   
                 		  
                     //如果上传目录为/static/images，则可以如下获取：                 
                     File upload = new File(path.getAbsolutePath(),"static/adviceImages/");
                     if(!upload.exists())                   	 
                    	 upload.mkdirs();                                     
                   
                    
                     String trueFileName =fileName.substring(fileName.length()-36);
                     String uploadFileName = upload.getAbsolutePath()+"/"+trueFileName; // 自定义的文件名称
                     
                     System.out.println(uploadFileName); 
                     multipartFile.transferTo(new File(uploadFileName));
                     
                     try
					{
                    	//照片转换成字节数组存储到数据库中
                         byte[] buffer = null;
                         FileInputStream fis = new FileInputStream(new File(uploadFileName));
                         ByteArrayOutputStream bos = new ByteArrayOutputStream();
                         byte[] b = new byte[1024];
                         int n;
                         while ((n = fis.read(b)) != -1)
                         {
                             bos.write(b, 0, n);
                         }
                         fis.close();
                         bos.close();
                         buffer = bos.toByteArray();
                         
                         userAdvice.setAdvicePhoto(buffer);
					} catch (Exception e)
					{
						// TODO: handle exception
					}
	             }
	            	       	
	            	else {
		            	    System.out.println("error1"); 
		                    return "error";	                    
		                }                       	            
		            }	                        
		            else {
		            	System.out.println("error2"); 
		                return "error";
		            }	            
			  }//end for 
        }       
        else {
        	System.out.println("error3"); 
            return "error";
        }
        
        UserAdviceService.insertUserAdvice(userAdvice);
        
        return "success";
        
    }	
}
