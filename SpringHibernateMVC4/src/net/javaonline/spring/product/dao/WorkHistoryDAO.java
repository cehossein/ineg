package net.javaonline.spring.product.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import net.javaonline.spring.product.model.WorkHistory;

public interface WorkHistoryDAO {

	public void add(WorkHistory i);
	public void add(WorkHistory i, int resume_id);
	public void update(WorkHistory i);
	public List<WorkHistory> list(int resume_id);   ///
	public WorkHistory getById(String startdate,String finishdate,String departmentname,int resume_id);
	public void remove(String startdate,String finishdate,String departmentname,int resume_id);
	public void updateByNameAndObject(String name,WorkHistory c);
	/*public void save(ContactDescription i);
	public List<ContactDescription> list();       ///
*/	
}


