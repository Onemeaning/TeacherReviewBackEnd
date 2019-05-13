package com.meanlam.te.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.meanlam.te.entity.Teacher;
import com.meanlam.te.service.TeacherService;
import com.meanlam.te.util.CommonUtils;
import com.meanlam.te.util.FaceMatch;

@RestController
@RequestMapping("/superadmin")
public class TeacherConrtoller {

	@Autowired
	private TeacherService teacherService;

	@RequestMapping(value = "/topFiveTeachers", method = RequestMethod.GET)
	public Map<String, Object> topFiveTeachers(String tAffiliation) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Teacher> teachers = teacherService.listTopFiveTeacher(tAffiliation);
		modelMap.put("success", teachers);
		return modelMap;
	}

	@RequestMapping(value = "/findByAffiliation", method = RequestMethod.GET)
	public Map<String, Object> findByAffiliation(String tAffiliation)//！！！！这个参数，与前端传过来的参数是要一一对应的，而不是和实体类中参数对应。
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Teacher> teachers = teacherService.findByAffiliation(tAffiliation);
		modelMap.put("teachers", teachers);
		return modelMap;
	}

	@RequestMapping(value = "/findByTeacherId", method = RequestMethod.GET)
	public Map<String, Object> findByTeacherId(String tId) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Teacher teacher = teacherService.findByTeacherId(tId);
		modelMap.put("success", teacher);
		return modelMap;
	}

	@RequestMapping(value = "/updateSupportCounts", method = RequestMethod.POST)
	public Map<String, Object> updateSupportCounts(@RequestBody Teacher teacher) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", teacherService.updateSupportCounts(teacher));
		return modelMap;
	}

	
	@RequestMapping(value = "/modifyTeacherInfo", method = RequestMethod.POST)
	public Map<String, Object> modifyTeacherInfo(@RequestBody Teacher teacher) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", teacherService.updateTeacherDetails(teacher));
		return modelMap;
	}
	
	/**
	 * 教师身份认证，根据老师调用的自拍照片以及数据库中存储的老师的照片进行比对
	 * @param request
	 * @param files
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value = "/teacherCertification")
	public Map<String, Object> teacherCertification(HttpServletRequest request,
			@RequestParam(value = "teahcerPhoto", required = false) MultipartFile[] files) throws Exception {
	
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		request.setCharacterEncoding("UTF-8");
		//获取表单的内容
		String tAffiliation = request.getParameter("tAffiliation");
		String tName = request.getParameter("tName");
		String tId = request.getParameter("tId");
		
		Teacher teacher = teacherService.getTeacherPhoto(tAffiliation, tName);
		
		/*数据库存储的旧的老师ID，这个ID绑定了老师没有授权登陆之前的所有的信息，如学生发来的邮件，点赞，评论；
		 * 因此如果老师认证成功了，我们需要将评论库，点赞库，邮件库，老师的ID进行重新绑定;
		*/		
		
		//获取数据中照片的URL地址;
		String photoFromDb = "";
		if (teacher == null)
		{
			 modelMap.put("success", "系统未找到您的信息？请联系管理员添加！");
			 return modelMap;
		}
		String oldteacherId = teacher.gettId();
		photoFromDb= CommonUtils.downloadPicture(teacher.gettPhoto());
		
		//处理图片文件(本地文件)
		String wxUploadPhotoPath = CommonUtils.deposePicFromWx(files);
			
		Map<String,String> judgeResult = FaceMatch.comparePhoto(photoFromDb,wxUploadPhotoPath);
		if (judgeResult.get(FaceMatch.NOT_LIFE)!=null)
		{
			 modelMap.put("success",judgeResult.get(FaceMatch.NOT_LIFE));
			 return modelMap;
		}
		else if (judgeResult.get(FaceMatch.COMPARE_FAIL)!=null) 
		{
			modelMap.put("success", judgeResult.get(FaceMatch.COMPARE_FAIL));
			return modelMap;
		}
		else if(judgeResult.get(FaceMatch.COMPARE_SUCCESS)!=null) 
		{
					
			//照片比对成功，认为是同一个人，更新数据库中的ID信息，让他与微信绑定
			Teacher t1 = new Teacher();
			t1.settName(tName);
			t1.settAffiliation(tAffiliation);
			t1.settId(tId);							
			boolean updateResult = teacherService.updateTeacherInfo(t1);//更新数据库的结果，正常不应该出错的；					
			if (!updateResult)
			{   
				modelMap.put("success", judgeResult.get(FaceMatch.COMPARE_SUCCESS)+"但是数据库更新失败！");
				modelMap.put("success", "fail");
			}
			else 
			{	
				teacherService.updateAllDatabaseTeacherId(tId,oldteacherId);
				modelMap.put("success", "success");
			}
			
			return modelMap;
		}
		else 
		{
			modelMap.put("success", "未知异常，请反馈给管理员");
		}
				
		return modelMap;		
	}

}
