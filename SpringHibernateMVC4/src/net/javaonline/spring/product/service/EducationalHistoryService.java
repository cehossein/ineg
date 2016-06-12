package net.javaonline.spring.product.service;

import java.util.List;

import net.javaonline.spring.product.model.EducationalHistory;

public interface EducationalHistoryService {
	
	public void add(EducationalHistory c);
	public void add(EducationalHistory c,int resume_id);
	public void update(EducationalHistory c);
	public List<EducationalHistory> list(int resume_id);   
	public EducationalHistory getById(String studyfield,String grade,String academicorientation,int resume_id);
	public void remove(String studyfield,String grade,String academicorientation,int resume_id);
	//public void updateByNameAndObject(String name,EducationalHistory c);
}
