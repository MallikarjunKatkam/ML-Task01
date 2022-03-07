package com.bhavna.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhavna.model.CourseEntity;
import com.bhavna.model.StudentEntity;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
    private SessionFactory sessionFactory;
		
	@Override
	public List <CourseEntity> getStudents() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery <CourseEntity> cq = cb.createQuery(CourseEntity.class);
        Root < CourseEntity > root = cq.from(CourseEntity.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

	@Override
	public void addStudent(StudentEntity student) {
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
	}

	@Override
	public StudentEntity getStudentById(Integer id) {
		Session currentSession = sessionFactory.openSession();
        StudentEntity theCustomer = currentSession.get(StudentEntity.class, id);
        currentSession.close();
        return theCustomer;
	}

	@Override
	public void updateStudent(Integer studentId, StudentEntity student) {
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();	      
        session.close();
	}
}
