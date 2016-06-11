package net.javaonline.spring.product.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.javaonline.spring.product.model.IndividualDescription;
import net.javaonline.spring.product.model.ItemMaster;
import net.javaonline.spring.product.model.Resume;

@Transactional
@Repository
public class ResumeDAOImpl implements ResumeDAO {
	
	public ResumeDAOImpl() {
		super();
	}


	private SessionFactory sessionFactory;
	
	public ResumeDAOImpl(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void add(Resume p) {
		/*Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);*/
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
	public void update(Resume r) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(r);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		session.getTransaction().commit();		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resume> list() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Resume> resumes = null;
		try {
			resumes = (List<Resume>)session.createQuery("from Resume").list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		
		return resumes;
	}

	@Override
	public Resume getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Resume resume=null;
		try {
			session.beginTransaction();
		    resume = (Resume) session.get(Resume.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		
		return resume;
	}
	

	@Override
	public void remove(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Resume resume = (Resume) session.get(Resume.class, id);
		if(null != resume) {
			session.delete(resume);
		}
		session.getTransaction().commit();
		
		//return item;
	}
	
	@Override
	public void updateByNameAndObject(String name, Resume r) {
		Session session = sessionFactory.getCurrentSession();
		Resume p = null ;
		try {
			session.beginTransaction();
			String sql = "select r.*"+" from resume r inner join user u on r.id = u.resume_id"+
			" where u.username = '" + name + "';";
			SQLQuery query = session.createSQLQuery(sql).addEntity(Resume.class);
			p = (Resume) query.uniqueResult();
			p.setFavoritycity(r.getFavoritycity());
			p.setFavorityjob(r.getFavorityjob());
			p.setRequestedwage(r.getRequestedwage());
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		
		
	}
	
	
/*	@Override
	public void save(Resume p) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Resume> list() {
		Session session = sessionFactory.openSession();
		List<Resume> UserList = session.createQuery("from Resume").list();
		session.close();
		return UserList;
	}
*/
}
