package net.javaonline.spring.product.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.javaonline.spring.product.model.EducationalHistory;
import net.javaonline.spring.product.model.WorkHistory;

@Transactional
@Repository
public class EducationalHistoryDAOImpl implements EducationalHistoryDAO {
	
	public EducationalHistoryDAOImpl() {
		super();
	}


	private SessionFactory sessionFactory;
	
	public EducationalHistoryDAOImpl(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void add(EducationalHistory p) {
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
	public void add(EducationalHistory p , int resume_id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			String sql = "insert into educational_history(resume_id,"+
			"study_field,grade,academic_orientation,university_name,"
			+ "start_date,finish_date,average" +
					") " +
					"values("+
					"'"+resume_id+"'"+
					",'"+p.getStudyfield()+"'"+
					",'"+p.getGrade()+"'"+
					",'"+p.getAcademicorientation()+"'"+
					",'"+p.getUniversityname()+"'"+
					",'"+p.getStartdate()+"'"+
					",'"+p.getFinishdate()+"'"+
					",'"+p.getAverage()+"'"+
					");";
			session.createSQLQuery(sql).executeUpdate();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
			
	}

	@Override
	public void update(EducationalHistory p) {
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
	public List<EducationalHistory> list(int resume_id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String sql = "select educational_history.*"+" from resume inner join educational_history on resume.id = educational_history.resume_id"+
		" where resume.id = '" + resume_id + "';";
		List<EducationalHistory> items = null;
		try {
			items = session.createSQLQuery(sql).addEntity(EducationalHistory.class).list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		
		return items;
	}

	@Override
	public EducationalHistory getById(String studyfield,String grade,String academicorientation,int resume_id) {
		Session session = sessionFactory.getCurrentSession();
		EducationalHistory item=null;
		try {
			session.beginTransaction();
			String sql = "select educational_history.*" +
			" from resume inner join educational_history on resume.id = educational_history.resume_id"+
			" where study_field = '" + studyfield +
			"' and grade = '" + grade +
			"' and academic_orientation = '" + academicorientation +
			"' and resume_id = '" + resume_id + 
			"';";
			item = (EducationalHistory) session.createSQLQuery(sql).addEntity(EducationalHistory.class).uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		
		return item;
	}
	

	@Override
	public void remove(String studyfield,String grade,String academicorientation,int resume_id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			String sql = "delete" +
			" from educational_history"+
			" where study_field = '" + studyfield +
			"' and grade = '" + grade +
			"' and academic_orientation = '" + academicorientation +
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
	
	/*@Override/////////////////
	public void updateByNameAndObject(String name, EducationalHistory c) {
		Session session = sessionFactory.getCurrentSession();
		EducationalHistory p = null ;
		try {
			session.beginTransaction();
			String sql = "select w.*"+" from educational_history w, resume r, user u"+
			" where u.username = '" + name + "';";
			SQLQuery query = session.createSQLQuery(sql).addEntity(WorkHistory.class);
			p = (EducationalHistory) query.list().get(0);
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
*/
	
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
