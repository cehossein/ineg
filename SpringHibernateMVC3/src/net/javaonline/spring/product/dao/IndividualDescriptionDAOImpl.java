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
	public void update(IndividualDescription p) {
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
	public List<IndividualDescription> list() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<IndividualDescription> items = null;
		try {
			items = (List<IndividualDescription>)session.createQuery("from IndividualDescription").list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		
		return items;
	}

	@Override
	public IndividualDescription getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		IndividualDescription item=null;
		try {
			session.beginTransaction();
		    item = (IndividualDescription) session.get(IndividualDescription.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		
		return item;
	}
	

	@Override
	public void remove(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		IndividualDescription item = (IndividualDescription) session.get(IndividualDescription.class, id);
		if(null != item) {
			session.delete(item);
		}
		session.getTransaction().commit();
		
		//return item;
	}
	
	@Override
	public void updateByNameAndObject(String name, IndividualDescription c) {
		Session session = sessionFactory.getCurrentSession();
		IndividualDescription p = null ;
		try {
			session.beginTransaction();
			String sql = "select i.*"+" from individual_description i inner join resume r on i.id = r.id inner join user u on r.id = u.resume_id"+
			" where u.username = '" + name + "';";
			SQLQuery query = session.createSQLQuery(sql).addEntity(IndividualDescription.class);
			p = (IndividualDescription) query.list().get(0);
			p.setEmail(c.getEmail());
			p.setLastname(c.getLastname());
			p.setMarriagestatus(c.getMarriagestatus());
			p.setName(c.getName());
			p.setSex(c.getSex());
			
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
