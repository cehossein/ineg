package net.javaonline.spring.product.dao;

import java.util.List;

import net.javaonline.spring.product.model.EducationalHistory;

public interface EducationalHistoryDAO {

	public void add(EducationalHistory i);
	public void add(EducationalHistory i, int resume_id);
	public void update(EducationalHistory i);
	public List<EducationalHistory> list(int resume_id);   ///
	public EducationalHistory getById(String studyfield,String grade,String academicorientation,int resume_id);
	public void remove(String studyfield,String grade,String academicorientation,int resume_id);
	//public void updateByNameAndObject(String name,EducationalHistory c);
	/*public void save(ContactDescription i);
	public List<ContactDescription> list();       ///
*/	
}


