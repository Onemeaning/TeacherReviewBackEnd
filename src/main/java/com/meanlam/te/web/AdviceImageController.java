package com.meanlam.te.web;


import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("superadmin")
public class AdviceImageController {
 
    /**
     * @param request
     * @param file
     * @return 上传成功返回“success”，上传失败返回“error”
     * @throws IOException
     */
	@ResponseBody
    @RequestMapping("/advice")
    public String upload(HttpServletRequest request, @RequestParam(value = "files", required = false) MultipartFile[] files) throws IOException {
        		
        request.setCharacterEncoding("UTF-8");
        
        //获取表单的内容
        String userId = request.getParameter("userId");
        String date = request.getParameter("date");
        String adviceType = request.getParameter("adviceType");
        String content = request.getParameter("content"); 
        
        System.out.println(userId+date+adviceType+content);
        
        
        //处理多个图片文件
        if(files != null && files.length > 0) {
        	
        	for (MultipartFile multipartFile : files)
			{
				
			
            String fileName = multipartFile.getOriginalFilename();
//            String path = null;
            String type = null;
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
           
            if (type != null)
            {
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                    
          /*      	// 项目在容器中实际发布运行的根路径
                    String realPath = request.getSession().getServletContext().getRealPath("/");
                    
                    // 自定义的文件名称
                    String trueFileName =fileName.substring(fileName.length()-36);
                    
                    System.out.println(trueFileName);
                    
                    // 设置存放图片文件的路径
                    path = realPath + "/uploads/" + trueFileName;
                    
                    File imageFile = new File(realPath+"/uploads/");
                    if (!imageFile.exists())
					{
						imageFile.mkdirs();
					}*/
                    
                    
                     //获取跟目录
                	
                	String urlPath = ResourceUtils.getURL("classpath:").getPath();              	
                    File path = new File(URLDecoder.decode(urlPath, "UTF-8"));   
                   		  
                     //如果上传目录为/static/images，则可以如下获取：
                    
                     File upload = new File(path.getAbsolutePath(),"static/adviceImages/");
                     if(!upload.exists()) 
                   	 
                    	 upload.mkdirs();                                     
                     
                     // 自定义的文件名称
                     String trueFileName =fileName.substring(fileName.length()-36);
                     String uploadFileName = upload.getAbsolutePath()+"/"+trueFileName;
                     
                     System.out.println(uploadFileName); 
                     multipartFile.transferTo(new File(uploadFileName));

		
		             }else {
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
        return "success";
    }	
}
