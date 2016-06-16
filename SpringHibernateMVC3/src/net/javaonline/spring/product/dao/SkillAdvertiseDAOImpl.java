package net.javaonline.spring.product.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.javaonline.spring.product.model.SkillAdvertise;
import net.javaonline.spring.product.model.Advertise;

@Transactional
@Repository
public class SkillAdvertiseDAOImpl implements SkillAdvertiseDAO {
	
	public SkillAdvertiseDAOImpl() {
		super();
	}


	private SessionFactory sessionFactory;
	
	public SkillAdvertiseDAOImpl(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void add(SkillAdvertise p) {
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
	public void add(SkillAdvertise p , int advertise_id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			String sql = "insert into skill_adv(advertise_id,"+
			"id,name) " +
					"values("+
					"'"+advertise_id+"'"+
					",'"+p.getId()+"'"+
					",'"+p.getName()+"'"+
					");";
			session.createSQLQuery(sql).executeUpdate();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

	@Override
	public void update(SkillAdvertise p) {
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
	public List<SkillAdvertise> list(int advertise_id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String sql = "select skill_adv.*"+" from advertise inner join skill_adv on advertise.id = skill_adv.advertise_id"+
		" where advertise.id = '" + advertise_id + "';";
		List<SkillAdvertise> items = null;
		try {
			items = session.createSQLQuery(sql).addEntity(SkillAdvertise.class).list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return items;
	}

	@Override
	public SkillAdvertise getById(int skill_id,int advertise_id) {
		Session session = sessionFactory.getCurrentSession();
		SkillAdvertise item=null;
		try {
			session.beginTransaction();
			String sql = "select skill_adv.*" +
			" from advertise inner join skill_adv on advertise.id = skill_adv.advertise_id"+
			" where skill_adv.id = '" + skill_id +
			"' and skill_adv.advertise_id = '" + advertise_id + 
			"';";
			item = (SkillAdvertise) session.createSQLQuery(sql).addEntity(SkillAdvertise.class).uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return item;
	}
	

	@Override
	public void remove(int skill_id,int advertise_id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			String sql = "delete" +
			" from skill_adv"+
			" where skill_adv.id = '" + skill_id +
			"' and skill_adv.advertise_id = '" + advertise_id + 
			"';";
			session.createSQLQuery(sql).executeUpdate();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		
		//return item;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Advertise> list(String skill_name) {
		Session session = sessionFactory.getCurrentSession();
		List<Advertise> items = null;
		try {
			session.beginTransaction();
			String sql = "select advertise.*"+" from advertise inner join skill_adv on advertise.id = skill_adv.advertise_id"+
			" where skill_adv.name = '" + skill_name + "';";
			
			items = (List<Advertise>)session.createSQLQuery(sql).addEntity(Advertise.class).list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		
		return items;
	}
	
	
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
