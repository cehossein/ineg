package net.javaonline.spring.product.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.javaonline.spring.product.model.Company;
import net.javaonline.spring.product.model.Resume;

@Transactional
@Repository
public class CompanyDAOImpl implements CompanyDAO {
	
	public CompanyDAOImpl() {
		super();
	}


	private SessionFactory sessionFactory;
	
	public CompanyDAOImpl(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void add(Company p) {
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
	public void update(Company r) {
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
	public List<Company> list() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Company> companys = null;
		try {
			companys = (List<Company>)session.createQuery("from Company").list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		
		return companys;
	}

	@Override
	public Company getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Company company=null;
		try {
			session.beginTransaction();
		    company = (Company) session.get(Company.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		
		return company;
	}
	

	@Override
	public void remove(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Company company = (Company) session.get(Company.class, id);
		if(null != company) {
			session.delete(company);
		}
		session.getTransaction().commit();
		
		//return item;
	}
	
	@Override
	public void updateByNameAndObject(String name, Company r) {
		Session session = sessionFactory.getCurrentSession();
		Company p = null ;
		try {
			session.beginTransaction();
			String sql = "select r.*"+" from resume r inner join user u on r.id = u.resume_id"+
			" where u.username = '" + name + "';";
			SQLQuery query = session.createSQLQuery(sql).addEntity(Company.class);
			p = (Company) query.uniqueResult();
			/*p.setFavoritycity(r.getFavoritycity());
			p.setFavorityjob(r.getFavorityjob());
			p.setRequestedwage(r.getRequestedwage());*/
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		
		
	}

	@Override
	public void add(Company company, int resume_id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			String sql = "insert into company(resume_id,"+
			"name,www,address) " +
					"values("+
					"'"+resume_id+"'"+
					",'"+company.getName()+"'"+
					",'"+company.getWww()+"'"+
					",'"+company.getAddress()+"'"+
					");";
			session.createSQLQuery(sql).executeUpdate();
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
