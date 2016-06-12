package net.javaonline.spring.product.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.javaonline.spring.product.model.User;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {
	
	public UserDAOImpl() {
		super();
	}
	
	
	public UserDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
	@Override
	public void add(User p) {		
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(p);
		  } catch (HibernateException e) {
			  e.printStackTrace();
			  session.getTransaction().rollback();
		}
			session.getTransaction().commit();
			
	}

	@Override
	public void update(User p) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(p);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		session.getTransaction().commit();		

	}

	@Override
	public User getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user=null;
		try {
			session.beginTransaction();
		    user = (User) session.get(User.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();

		return user;
	}
	


	@Override
	public void remove(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		User user = (User) session.get(User.class, id);
		if(null != user) {
			session.delete(user);
		}
		session.getTransaction().commit();

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<User> users = null;
		try {
			users = (List<User>)session.createQuery("from User").list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();

		return users;
	}
	
	@Override
	public User getUserByUserName(String username) {
		Session session = sessionFactory.getCurrentSession();
		User p = null ;
		try {
			session.beginTransaction();
			String hql = "from User where username=:username";
			Query query = session.createQuery(hql);
			query.setString("username",username);
			p = (User) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();

		return p;
	}

/*	
	@SuppressWarnings("unchecked")
	public List<User> list() {
		Session session = sessionFactory.openSession();
		List<User> UserList = session.createQuery("from User").list();
		session.close();
		return UserList;
	}

	

	
	@Override
	public void save(User p) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}*/
}
