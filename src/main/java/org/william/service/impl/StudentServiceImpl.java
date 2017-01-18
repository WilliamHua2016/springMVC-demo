package org.william.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.william.dao.BaseDao;
import org.william.dao.IStudentMapper;
import org.william.model.Student;
import org.william.service.IStudentService;
import org.william.util.mongo.MongoException;
import org.william.util.mongo.MongoOps;

@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private IStudentMapper studentMapper;
	@Autowired
	private BaseDao baseDao;
	
	@Autowired
	private MongoOps mongoOps;

	@Override
	public void addStudent(Student student) {
		//studentMapper.addStudent(student);
		baseDao.insert("org.william.dao.IStudentMapper.addStudent", student);
		System.out.println("-----插入mongo DB 开始------");
		try {
			mongoOps.insertObject("student", student);
		} catch (MongoException e) {
			e.printStackTrace();
			
			System.out.println("-----插入mongo DB ERROR !!! ERROR !!!------");
		}
		
		System.out.println("-----插入mongo DB END------");
	}

}
