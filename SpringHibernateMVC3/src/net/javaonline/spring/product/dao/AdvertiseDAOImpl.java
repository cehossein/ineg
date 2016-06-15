package net.javaonline.spring.product.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.javaonline.spring.product.model.Advertise;

@Transactional
@Repository
public class AdvertiseDAOImpl implements AdvertiseDAO {
	
	public AdvertiseDAOImpl() {
		super();
	}


	private SessionFactory sessionFactory;
	
	public AdvertiseDAOImpl(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void add(Advertise p) {
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
	public void add(Advertise p , int resume_id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			/*session.beginTransaction();
			String sql = "insert into skill(resume_id,"+
			"id,name) " +
					"values("+
					"'"+resume_id+"'"+
					",'"+p.getId()+"'"+
					",'"+p.getName()+"'"+
					");";*/
			/*session.createSQLQuery(sql).executeUpdate();*/
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

	@Override
	public void update(Advertise p) {
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
	public List<Advertise> list(int resume_id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String sql = "select skill.*"+" from resume inner join skill on resume.id = skill.resume_id"+
		" where resume.id = '" + resume_id + "';";
		List<Advertise> items = null;
		try {
			items = session.createSQLQuery(sql).addEntity(Advertise.class).list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return items;
	}

	@Override
	public Advertise getById(int skill_id,int resume_id) {
		Session session = sessionFactory.getCurrentSession();
		Advertise item=null;
		try {
			session.beginTransaction();
			String sql = "select skill.*" +
			" from resume inner join skill on resume.id = skill.resume_id"+
			" where skill.id = '" + skill_id +
			"' and resume_id = '" + resume_id + 
			"';";
			item = (Advertise) session.createSQLQuery(sql).addEntity(Advertise.class).uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return item;
	}
	

	@Override
	public void remove(int skill_id,int resume_id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			String sql = "delete" +
			" from skill"+
			" where id = '" + skill_id +
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

	@Override
	public void add(Advertise advertise, int resume_id, int contactDescrptionId) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			String sql = "insert into advertise(resume_id,cont_id,"+
			"propagate_date,co_name,wage,adv_text,title,city_name) " +
					"values("+
					"'"+resume_id+"'"+
					",'"+contactDescrptionId+"'"+
					",'"+advertise.getPropagateDate()+"'"+
					",'"+advertise.getCoName()+"'"+
					",'"+advertise.getWage()+"'"+
					",'"+advertise.getAdvText()+"'"+
					",'"+advertise.getTitle()+"'"+
					",'"+advertise.getCityName()+"'"+
					");";
			session.createSQLQuery(sql).executeUpdate();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		
	}
	
	/*@SuppressWarnings("unchecked")
	@Override
	public List<Advertise> list(String skill_name) {
		Session session = sessionFactory.getCurrentSession();
		List<Advertise> items = null;
		try {
			session.beginTransaction();
			String sql = "select resume.*"+" from resume inner join skill on resume.id = skill.resume_id"+
			" where skill.name = '" + skill_name + "';";
			
			items = (List<Resume>)session.createSQLQuery(sql).addEntity(Resume.class).list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		
		return items;
	}
	*/
	
/*	@Override/////////////////
	public void updateByNameAndObject(String name, Skill c) {
		Session session = sessionFactory.getCurrentSession();
		Skill p = null ;
		try {
			session.beginTransaction();
			String sql = "select w.*"+" from work_history w, resume r, user u"+
			" where u.username = '" + name + "';";
			SQLQuery query = session.createSQLQuery(sql).addEntity(WorkHistory.class);
			p = (Skill) query.list().get(0);
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
		
		
	}*/

	
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
