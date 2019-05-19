package com.meanlam.te.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.UUID;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

public class CommonUtils {
	
public static String MYURL = "https://www.nest-lab.com/wx-te-0.0.2-SNAPSHOT/";
//public static String MYURL = "http://49.123.68.14:8080/";

//处理微信小程序拍照发过来的照片	
public static String deposePicFromWx(MultipartFile[] files,String tempPath) throws Exception {
	String uploadFileName = null;
    if(files != null && files.length > 0) {      	
    	for (MultipartFile multipartFile : files)
		{	
    		//获取原始图像名
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
                 File upload = new File(path.getAbsolutePath(),"static/"+tempPath+"/");
                 if(!upload.exists())                   	 
                	 upload.mkdirs();                                                                     
                 String trueFileName =fileName.substring(fileName.length()-36);         
                 //得到文件名字
                 uploadFileName = upload.getAbsolutePath()+"/"+trueFileName; // 自定义的文件名称           
                 multipartFile.transferTo(new File(uploadFileName));                   
	          }
	            	
	        	else 
	        	{
	        		return null;//照片格式不正确                    
		        }                       	            
	                        
            }	                        
	            else {
	            	
	                return null;//传输照片的地址有问题
	            }	           	            
		  }
    }       
    else 
    {
        return null;//files为空
    }
	return uploadFileName;
 }



//链接url下载图片
public static String downloadPicture(String urlList,String tempPath) {
    URL url = null;
    String path = null;
    try {
    	
    	//获取跟目录             	
    	String urlPath = ResourceUtils.getURL("classpath:").getPath();              	
        File contextPath = new File(URLDecoder.decode(urlPath, "UTF-8"));   
     		  
         //如果上传目录为/static/adviceImages，则可以如下获取：                 
         File upload = new File(contextPath.getAbsolutePath(),"static/"+tempPath+"/");
         if(!upload.exists())                   	 
        	 upload.mkdirs();                                     
                          
         String trueFileName =uuid()+".jpg";   
         //得到文件名字
         path = upload.getAbsolutePath()+"/"+trueFileName; // 自定义的文件名称
         
          	
        url = new URL(urlList);
        DataInputStream dataInputStream = new DataInputStream(url.openStream());

        FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];
        int length;

        while ((length = dataInputStream.read(buffer)) > 0) {
            output.write(buffer, 0, length);
        }
        fileOutputStream.write(output.toByteArray());
        dataInputStream.close();
        fileOutputStream.close();
    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return path;
}

public static String writeBytesToFile(byte[] bs,String tempFilePath) {
	
	String path = null;
	String trueFileName = null;
	try
	{
	//获取跟目录             	
	String urlPath = ResourceUtils.getURL("classpath:").getPath();              	
	File contextPath = new File(URLDecoder.decode(urlPath, "UTF-8"));   
		  
	 //如果上传目录为/static/adviceImages，则可以如下获取：                 
	 File upload = new File(contextPath.getAbsolutePath(),"static/"+tempFilePath+"/");
	 if(!upload.exists())                   	 
		 upload.mkdirs();                                     
	                  
	 trueFileName =uuid()+".jpg";   
	 
	 //得到文件名字
	 path = upload.getAbsolutePath()+"/"+trueFileName; // 自定义的文件名称
	  
	 OutputStream out;
	 out = new FileOutputStream(path);
	
	 InputStream is = new ByteArrayInputStream(bs);
	 byte[] buff = new byte[1024];
	 int len = 0;
	 while((len=is.read(buff))!=-1){
	     out.write(buff, 0, len);
	 }
	 is.close();
	 out.close();
	} 
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return trueFileName;
}





/** 
 * 删除目录（文件夹）以及目录下的文件 
 * @param   sPath 被删除目录的文件路径 
 * @return  目录删除成功返回true，否则返回false 
 */  
public static boolean deleteDirectory(String sPath) {  
    //如果sPath不以文件分隔符结尾，自动添加文件分隔符  
    if (!sPath.endsWith(File.separator)) {  
        sPath = sPath + File.separator;  
    }  
    File dirFile = new File(sPath);  
    //如果dir对应的文件不存在，或者不是一个目录，则退出  
    if (!dirFile.exists() || !dirFile.isDirectory()) {  
        return false;  
    }  
    boolean flag = true;  
    //删除文件夹下的所有文件(包括子目录)  
    File[] files = dirFile.listFiles();  
    for (int i = 0; i < files.length; i++) {  
        //删除子文件  
        if (files[i].isFile()) {  
            flag = deleteFile(files[i].getAbsolutePath());  
            if (!flag) break;  
        } //删除子目录  
        else {  
            flag = deleteDirectory(files[i].getAbsolutePath());  
            if (!flag) break;  
        }  
    }  
    if (!flag) return false;  
    //删除当前目录  
    if (dirFile.delete()) {  
        return true;  
    } else {  
        return false;  
    }  
 }

/** 
 * 删除单个文件 
 * @param   sPath    被删除文件的文件名 
 * @return 单个文件删除成功返回true，否则返回false 
 */  
public static boolean deleteFile(String sPath) {  
    boolean flag = false;  
    File file = new File(sPath);  
    // 路径为文件且不为空则进行删除  
    if (file.isFile() && file.exists()) {  
        file.delete();  
        flag = true;  
    }  
    return flag;  
}

/** 
 *根据路径删除指定的目录或文件，无论存在与否 
 *@param sPath  要删除的目录或文件 
 *@return 删除成功返回 true，否则返回 false。 
 */  
public static boolean deleteFolder(String sPath) {  
   boolean flag = false;  
   File file = new File(sPath);  
    // 判断目录或文件是否存在  
    if (!file.exists()) {  // 不存在返回 false  
        return flag;  
    } else {  
        // 判断是否为文件  
        if (file.isFile()) {  // 为文件时调用删除文件方法  
            return deleteFile(sPath);  
        } else {  // 为目录时调用删除目录方法  
            return deleteDirectory(sPath);  
        }  
    }  
}
public static String uuid()
{
	return UUID.randomUUID().toString().replaceAll("-", "");
}
}
