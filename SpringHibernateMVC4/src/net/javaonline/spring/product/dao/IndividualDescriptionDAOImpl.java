package net.javaonline.spring.product.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.javaonline.spring.product.model.IndividualDescription;



@Transactional
@Repository
public class IndividualDescriptionDAOImpl implements IndividualDescriptionDAO {
	
	public IndividualDescriptionDAOImpl() {
		super();
	}


	private SessionFactory sessionFactory;
	
	public IndividualDescriptionDAOImpl(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void add(IndividualDescription p) {
		/*Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);*/
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(p);
			session.flush();
		  } catch (HibernateException e) {
			  e.printStackTrace();
			  session.getTransaction().rollback();
		}
			session.getTransaction().commit();
			session.close();
			
	}

	@Override
	public void update(IndividualDescription p) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(p);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		session.getTransaction().commit();	
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IndividualDescription> list() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<IndividualDescription> items = null;
		try {
			items = (List<IndividualDescription>)session.createQuery("from IndividualDescription").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.flush();
		session.getTransaction().commit();
		session.close();
		return items;
	}

	@Override
	public IndividualDescription getById(int id) {
		Session session = sessionFactory.openSession();
		IndividualDescription individualDescription=null;
		try {
			session.beginTransaction();
			individualDescription = (IndividualDescription) session.get(IndividualDescription.class, id);
			session.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		session.close();
		return individualDescription;
	}
	

	@Override
	public void remove(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		IndividualDescription individualDescription = (IndividualDescription) session.get(IndividualDescription.class, id);
		if(null != individualDescription) {
			session.delete(individualDescription);
		}
		session.getTransaction().commit();
		
		//return item;
	}
	
/*	@Override
	public void save(IndividualDescription p) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<IndividualDescription> list() {
		Session session = sessionFactory.openSession();
		List<IndividualDescription> UserList = session.createQuery("from IndividualDescription").list();
		session.close();
		return UserList;
	}
*/
	@Override
	public void updateByIdAndObject(int id, IndividualDescription i) {
		Session session = sessionFactory.openSession();
		IndividualDescription p = null ;
		try {
			session.beginTransaction();
			String sql = "select i.*"+" from individual_description i inner join resume r on i.id = r.indi_id"+
			" where i.id = '" + id + "';";
			SQLQuery query = session.createSQLQuery(sql).addEntity(IndividualDescription.class);
			p = (IndividualDescription) query.uniqueResult();
			p.setEmail(i.getEmail());
			p.setLastname(i.getLastname());
			p.setMarriagestatus(i.getMarriagestatus());
			p.setName(i.getName());
			p.setSex(i.getSex());
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		
		
	}

}
