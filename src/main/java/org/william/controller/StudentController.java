package org.william.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.william.model.Student;
import org.william.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private IStudentService studentServiceImpl;

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String addStudent(@RequestParam("name") String name,
			@RequestParam("sex") String sex) {
		Student student = new Student();
		student.setName(name);
		student.setSex(sex);
		try {
			studentServiceImpl.addStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
			return " add student ERROR! ERROR!";
		}
		return " add student sucess!";
	}
	
	@RequestMapping(value = "/testTransaction", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String testTransaction(@RequestParam("name") String name,
			@RequestParam("sex") String sex){
	
		Student student = new Student();
		student.setName(name);
		student.setSex(sex);
		try {
			studentServiceImpl.testTransaction(student);
		} catch (Exception e) {
			e.printStackTrace();
			return " testTransaction ERROR! ERROR!";
		}
		return " testTransaction sucess!";
	}

}
