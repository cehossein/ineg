package net.javaonline.spring.product.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.javaonline.spring.product.model.WorkHistory;

@Transactional
@Repository
public class WorkHistoryDAOImpl implements WorkHistoryDAO {
	
	public WorkHistoryDAOImpl() {
		super();
	}


	private SessionFactory sessionFactory;
	
	public WorkHistoryDAOImpl(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void add(WorkHistory p) {
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
	public void add(WorkHistory p , int resume_id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			String sql = "insert into work_history(resume_id,"+
			"start_date,finish_date,department_name,last_reward," +
					"work_field) " +
					"values("+
					"'"+resume_id+"'"+
					",'"+p.getStartdate()+"'"+
					",'"+p.getFinishdate()+"'"+
					",'"+p.getDepartmentname()+"'"+
					",'"+p.getLastreward()+"'"+
					",'"+p.getWorkfield()+"'"+
					");";
			session.createSQLQuery(sql).executeUpdate();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
			
	}

	@Override
	public void update(WorkHistory p) {
		/*Session session = this.sessionFactory.getCurrentSession();
		session.update(p);*/
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

	@SuppressWarnings("unchecked")
	@Override
	public List<WorkHistory> list(int resume_id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String sql = "select work_history.*"+" from resume inner join work_history on resume.id = work_history.resume_id"+
		" where resume.id = '" + resume_id + "';";
		List<WorkHistory> items = null;
		try {
			items = session.createSQLQuery(sql).addEntity(WorkHistory.class).list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		
		return items;
	}

	@Override
	public WorkHistory getById(String startdate,String finishdate,String departmentname,int resume_id) {
		Session session = sessionFactory.getCurrentSession();
		WorkHistory item=null;
		try {
			session.beginTransaction();
			String sql = "select work_history.*" +
			" from resume inner join work_history on resume.id = work_history.resume_id"+
			" where start_date = '" + startdate +
			"' and finish_date = '" + finishdate +
			"' and department_name = '" + departmentname +
			"' and resume_id = '" + resume_id + 
			"';";
			item = (WorkHistory) session.createSQLQuery(sql).addEntity(WorkHistory.class).uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		
		return item;
	}
	

	@Override
	public void remove(String startdate,String finishdate,String departmentname,int resume_id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			String sql = "delete" +
			" from work_history"+
			" where start_date = '" + startdate +
			"' and finish_date = '" + finishdate +
			"' and department_name = '" + departmentname +
			"' and resume_id = '" + resume_id + 
			"';";
			session.createSQLQuery(sql).executeUpdate();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		//return item;
	}
	
	@Override/////////////////
	public void updateByNameAndObject(String name, WorkHistory c) {
		Session session = sessionFactory.getCurrentSession();
		WorkHistory p = null ;
		try {
			session.beginTransaction();
			String sql = "select w.*"+" from work_history w, resume r, user u"+
			" where u.username = '" + name + "';";
			SQLQuery query = session.createSQLQuery(sql).addEntity(WorkHistory.class);
			p = (WorkHistory) query.list().get(0);
			p.setDepartmentname(c.getDepartmentname());
			p.setFinishdate(c.getFinishdate());
			p.setLastreward(c.getLastreward());
			p.setStartdate(c.getStartdate());
			p.setWorkfield(c.getWorkfield());
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		
		
	}

	
/*	@Override
	public void save(ContactDescription p) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<ContactDescription> list() {
		Session session = sessionFactory.openSession();
		List<ContactDescription> ContactDescriptionList = session.createQuery("from ContactDescription").list();
		session.close();
		return ContactDescriptionList;
	}
*/
}
