package com.meanlam.te.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meanlam.te.entity.Teacher;
import com.meanlam.te.service.TeacherService;

@RestController
@RequestMapping("/superadmin")
public class TeacherConrtoller {
	
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping(value = "/topFiveTeachers",method=RequestMethod.GET)
	public Map<String,Object> topFiveTeachers(){
		Map<String, Object> modelMap = new HashMap<String,Object>();
		List<Teacher> teachers = teacherService.listTopFiveTeacher();
		modelMap.put("success", teachers);
		return modelMap;
	}
	
	@RequestMapping(value = "/findByAffiliation",method=RequestMethod.GET)
	public Map<String,Object> findByAffiliation(String tAffiliation)//！！！！这个参数，与前端传过来的参数是要一一对应的，而不是和实体类中参数对应。
	{		
		Map<String, Object> modelMap = new HashMap<String,Object>();
		List<Teacher> teachers = teacherService.findByAffiliation(tAffiliation);	
		modelMap.put("teachers", teachers);
		return modelMap;
	}
	
	@RequestMapping(value="/findByTeacherId",method=RequestMethod.GET)
	public Map<String, Object>findByTeacherId(String tId)
	{
		Map<String, Object> modelMap = new HashMap<String,Object>();
		Teacher teacher = teacherService.findByTeacherId(tId);
		modelMap.put("success", teacher);
		return modelMap;
	}
	
	@RequestMapping(value="/updateSupportCounts",method=RequestMethod.POST)
	public Map<String, Object> updateSupportCounts(@RequestBody Teacher teacher)
	{
		Map<String, Object> modelMap = new HashMap<String,Object>();
		modelMap.put("success", teacherService.updateSupportCounts(teacher));
		return modelMap;
	}
	
}
