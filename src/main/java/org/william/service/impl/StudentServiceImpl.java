package org.william.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.william.dao.BaseDao;
import org.william.dao.IStudentMapper;
import org.william.model.Student;
import org.william.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private IStudentMapper studentMapper;
	@Autowired
	private BaseDao baseDao;

	@Override
	public void addStudent(Student student) {
		//studentMapper.addStudent(student);
		baseDao.insert("org.william.dao.IStudentMapper.addStudent", student);
	}

}
