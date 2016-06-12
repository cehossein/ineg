package net.javaonline.spring.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaonline.spring.product.dao.EducationalHistoryDAO;
import net.javaonline.spring.product.model.EducationalHistory;

@Transactional
@Service
public class EducationalHistoryServiceImpl implements EducationalHistoryService {
	
	private EducationalHistoryDAO educationalHistoryDAO;
	
	public void setEducationalHistoryDAO(EducationalHistoryDAO educationalHistoryDAO) {
		this.educationalHistoryDAO = educationalHistoryDAO;
	}
	
	@Override
	public void add(EducationalHistory c) {
		this.educationalHistoryDAO.add(c);
	}
	
	@Override
	public void add(EducationalHistory c,int resume_id) {
		this.educationalHistoryDAO.add(c,resume_id);
	}

	@Override
	public void update(EducationalHistory c) {
		this.educationalHistoryDAO.update(c);
	}

	@Override
	public List<EducationalHistory> list(int resume_id) {
		return this.educationalHistoryDAO.list(resume_id);
	}

	@Override
	public EducationalHistory getById(String studyfield,String grade,String academicorientation,int resume_id) {
		return this.educationalHistoryDAO.getById(studyfield,grade,academicorientation,resume_id);
	}

	@Override
	public void remove(String studyfield,String grade,String academicorientation,int resume_id) {
		this.educationalHistoryDAO.remove(studyfield,grade,academicorientation,resume_id);
	}
	
/*	@Override
	public void updateByNameAndObject(String name,EducationalHistory c){
		this.educationalHistoryDAO.updateByNameAndObject(name,c);
	}*/
}
