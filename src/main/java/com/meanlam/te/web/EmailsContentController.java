package com.meanlam.te.web;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.meanlam.te.entity.EmailsContent;
import com.meanlam.te.entity.UserAdvice;
import com.meanlam.te.service.EmailsContentService;
import com.meanlam.te.util.CommonUtils;

@RestController
@RequestMapping("/superadmin")
public class EmailsContentController {

	
	@Autowired
	private EmailsContentService emailsContentService;
	
	
	/*
	 * 根据老师的自己的ID查看接收到的邮件情况
	 */
	@RequestMapping(value = "/getAllEmails", method = RequestMethod.GET)
	private Map<String, Object> getAllEmails(String toId)
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<EmailsContent> emailsList = emailsContentService.getAllEmails(toId);
		for (EmailsContent emailsContent : emailsList)
		{
			byte[] bys = emailsContent.getFile();
			if (bys!=null)
			{
				emailsContent.setResumeUrl(CommonUtils.MYURL+"tempImages/"+CommonUtils.writeBytesToFile(bys));		
			}				
		}
		modelMap.put("success", emailsList);//这个键（success）会在客户端直接获取
		return modelMap;
	}
	
	
	/*
	 * 根据前台传来的临时的图片的URL地址删除文件
	 */
	@RequestMapping(value = "/deletetempPic", method = RequestMethod.GET)
	private Map<String, Object> deletetempPic(String resumeUrl)
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		boolean result = false;
		try
		{
		//获取跟目录             	
		String urlPath = ResourceUtils.getURL("classpath:").getPath();              	
		File contextPath = new File(URLDecoder.decode(urlPath, "UTF-8"));  
		String tempFilePath = contextPath+"\\static\\"+resumeUrl+"\\";
		result = CommonUtils.deleteFolder(tempFilePath);		
		} catch (Exception e)
		{
			// TODO: handle exception
		}		
		modelMap.put("success", result);//这个键（success）会在客户端直接获取
		return modelMap;
	}
		
	/*
	 * 根据自己的ID，将邮件的查看状态设置为已查看
	 */
	@RequestMapping(value = "/emailsChecked", method = RequestMethod.POST)
	private Map<String, Object> emailsChecked(@RequestBody EmailsContent emailsContent)
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", emailsContentService.emailsChecked(emailsContent));
		return modelMap;
	}
	
	
	/*
	 * 根据ID，删除用户的一条邮件
	 * @return
	 */
	@RequestMapping(value="/removeEmail",method = RequestMethod.POST)
	private Map<String, Object> removeEmail(@RequestBody EmailsContent emailsContent)
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", emailsContentService.deleteById(emailsContent));
		return modelMap;
	}

	/*
	 * 根据ID，删除用户所有的邮件
	 * @return
	 */
	@RequestMapping(value="/removeAllEmails",method = RequestMethod.GET)
	private Map<String, Object> removeAllEmails(String toId)
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", emailsContentService.deleteAll(toId));
		return modelMap;
	}
	
	
	/*
	 * 获取未读邮件的数量
	 * @return
	 */
	@RequestMapping(value="/uncheckedEmailsNum",method = RequestMethod.GET)
	private Map<String, Object> uncheckedEmailsNum(String toId)
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", emailsContentService.uncheckedEmailsNum(toId));
		return modelMap;
	}
	
	
	/*
	 * 系统通知信息,（写一封没有照片的私信）
	 * @return
	 */
	@RequestMapping(value="/notifyInfo",method = RequestMethod.POST)
	private Map<String, Object> notifyInfo(@RequestBody EmailsContent emailsContent)
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();		
		modelMap.put("success", emailsContentService.writeEmail(emailsContent));
		System.out.println(modelMap.get("success"));
		return modelMap;
	}

	
	/**
	 *     写邮件
	 * @param request
	 * @param files
	 * @return
	 * @throws IOException
	 * 
	 */
	@ResponseBody
    @RequestMapping(value="/writeEmail")
    public String writeEmail(HttpServletRequest request, @RequestParam(value = "resumePhoto", required = false) MultipartFile[] files) throws IOException {     		
		request.setCharacterEncoding("UTF-8");     
        //获取表单的内容
        String fromId = request.getParameter("fromId");
        String fromIdImage = request.getParameter("fromIdImage");
        String fromIdNickName = request.getParameter("fromIdNickName");
        String toId = request.getParameter("toId"); 
        String sendTime = request.getParameter("sendTime"); 
        String emailContent = request.getParameter("emailContent"); 
        
	      EmailsContent emailsContent = new EmailsContent();
	      emailsContent.setChecked(false);
	      emailsContent.setFromId(fromId);
	      emailsContent.setFromIdImage(fromIdImage);
	      emailsContent.setFromIdNickName(fromIdNickName);
	      emailsContent.setToId(toId);
	      emailsContent.setSendTime(sendTime);
	      emailsContent.setEmailContent(emailContent);
      
           
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
                         emailsContent.setFile(buffer);
                         
                         
                         
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
        
		
        emailsContentService.writeEmail(emailsContent);
        
        return "success";
        
    }	
	
	
	
}
