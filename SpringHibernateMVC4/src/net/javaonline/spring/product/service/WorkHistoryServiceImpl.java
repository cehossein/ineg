package net.javaonline.spring.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaonline.spring.product.dao.WorkHistoryDAO;
import net.javaonline.spring.product.model.WorkHistory;

@Transactional
@Service
public class WorkHistoryServiceImpl implements WorkHistoryService {
	
	private WorkHistoryDAO workHistoryDAO;
	
	public void setWorkHistoryDAO(WorkHistoryDAO workHistoryDAO) {
		this.workHistoryDAO = workHistoryDAO;
	}
	
	@Override
	public void add(WorkHistory c) {
		this.workHistoryDAO.add(c);
	}
	
	@Override
	public void add(WorkHistory c,int resume_id) {
		this.workHistoryDAO.add(c,resume_id);
	}

	@Override
	public void update(WorkHistory c) {
		this.workHistoryDAO.update(c);
	}

	@Override
	public List<WorkHistory> list(int resume_id) {
		return this.workHistoryDAO.list(resume_id);
	}

	@Override
	public WorkHistory getById(String startdate,String finishdate,String departmentname,int resume_id) {
		return this.workHistoryDAO.getById(startdate,finishdate,departmentname,resume_id);
	}

	@Override
	public void remove(String startdate,String finishdate,String departmentname,int resume_id) {
		this.workHistoryDAO.remove(startdate,finishdate,departmentname,resume_id);
	}
	
	@Override
	public void updateByNameAndObject(String name,WorkHistory c){
		this.workHistoryDAO.updateByNameAndObject(name,c);
	}
}
