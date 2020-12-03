package com.aptechkharghar.DAO;

import java.util.List;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aptechkharghar.entities.User;
@Repository("userDAO")
public class UserDAO {
	
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
	}
	
	public List<User> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query<User> query = session.createQuery("from User", User.class);
		List<User> list = query.getResultList();
		session.getTransaction().commit();
		return list;
	}
	
	 public User getUserById(Integer Id) {
		 Session session = sessionFactory.getCurrentSession();
		 session.beginTransaction();
		 User user = (User) session.get(User.class, Id);
		 session.getTransaction().commit();
		 return user;
	}
	 
	 public void deleteUser(User userObj) {
		 Session session = sessionFactory.getCurrentSession();
		 session.beginTransaction();
		 session.delete(userObj);
		 session.getTransaction().commit();
	}
}
