package com.gatherup.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gatherup.model.Person;

@Repository("personRepo")
public class PersonRepo {

	private SessionFactory sesFact;
	
	@Autowired
	public PersonRepo(SessionFactory sesFact) {
		this.sesFact = sesFact;
	}
	
	@Transactional
	public List<Person> selectAll(){

		Session ses = sesFact.openSession();
		
		List<Person> planetList = ses.createQuery("from Planet",Person.class).list();
		
		ses.close();
		
		return planetList;
		
	}
	
	public Person selectByUserId(int id) {
		Person p = null;
		
		return p;
	}
	
	@Transactional
	public void insert(Person p) {
		
		Session ses = sesFact.openSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(p);
		
		tx.commit();
		ses.close();
		
	}
	
	@Transactional
	public void delete(Person p) {
		
//		Session ses = sesFact.openSession();
//		Transaction tx = ses.beginTransaction();
//		
//		ses.delete(p);
//		
//		tx.commit();
//		ses.close();
		
		sesFact.getCurrentSession().delete(p); //Using contextual sessions
		
	}
	
	public void update(Person p) {
		
		
		
	}

}
