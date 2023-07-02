package com.orm.springorm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.orm.springorm.entities.Student;



public class StudentDao {


	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public int insert(Student student) {
		Integer i=(Integer)this.hibernateTemplate.save(student);
		
		return i;
		
	}
	//get one roow
	public Student getStudent(int studentId) {
		Student student=this.hibernateTemplate.get(Student.class,studentId);
		
		return student;
	}
	//get all rows
	public List<Student> getAllStudents(){
		List<Student> students=this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	//delete using id
	@Transactional
	public void delete( int studentId) {
		Student student=this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}
	//update
	@Transactional
	public void update(Student student) {
		this.hibernateTemplate.update(student);
	}
	
}
