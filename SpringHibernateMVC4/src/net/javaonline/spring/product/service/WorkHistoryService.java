package net.javaonline.spring.product.service;

import java.util.List;

import net.javaonline.spring.product.model.WorkHistory;

public interface WorkHistoryService {
	
	public void add(WorkHistory c);
	public void add(WorkHistory c,int resume_id);
	public void update(WorkHistory c);
	public List<WorkHistory> list(int resume_id);   
	public WorkHistory getById(String startdate,String finishdate,String departmentname,int resume_id);
	public void remove(String startdate,String finishdate,String departmentname,int resume_id);
	public void updateByNameAndObject(String name,WorkHistory c);
}
