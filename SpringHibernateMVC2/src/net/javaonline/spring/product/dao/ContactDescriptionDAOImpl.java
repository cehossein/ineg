package net.javaonline.spring.product.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.javaonline.spring.product.model.ContactDescription;
import net.javaonline.spring.product.model.IndividualDescription;

@Transactional
@Repository
public class ContactDescriptionDAOImpl implements ContactDescriptionDAO {
	
	public ContactDescriptionDAOImpl() {
		super();
	}


	private SessionFactory sessionFactory;
	
	public ContactDescriptionDAOImpl(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void add(ContactDescription p) {
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
	public void update(ContactDescription p) {
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
	public List<ContactDescription> list() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<ContactDescription> items = null;
		try {
			items = (List<ContactDescription>)session.createQuery("from ContactDescription").list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return items;
	}

	@Override
	public ContactDescription getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		ContactDescription item=null;
		try {
			session.beginTransaction();
		    item = (ContactDescription) session.get(ContactDescription.class, id);
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
		ContactDescription item = (ContactDescription) session.get(ContactDescription.class, id);
		if(null != item) {
			session.delete(item);
		}
		session.getTransaction().commit();
		//return item;
	}
	
	@Override
	public void updateByNameAndObject(String name, ContactDescription c) {
		Session session = sessionFactory.getCurrentSession();
		ContactDescription p = null ;
		try {
			session.beginTransaction();
			String sql = "select c.*"+" from contact_description c, resume r, user u"+
			" where u.username = '" + name + "';";
			SQLQuery query = session.createSQLQuery(sql).addEntity(ContactDescription.class);
			p = (ContactDescription) query.list().get(0);
			p.setAddress(c.getAddress());
			p.setEmail(c.getEmail());
			p.setPhone(c.getPhone());
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
