package net.javaonline.spring.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaonline.spring.product.dao.ResumeDAO;
import net.javaonline.spring.product.model.IndividualDescription;
import net.javaonline.spring.product.model.Resume;

@Transactional
@Service
public class ResumeServiceImpl implements ResumeService {
	
	private ResumeDAO resumeDAO;
	
	public void setResumeDAO(ResumeDAO resumeDAO) {
		this.resumeDAO = resumeDAO;
	}
	
	@Override
	public void add(Resume r) {
		this.resumeDAO.add(r);
	}

	@Override
	public void update(Resume r) {
		this.resumeDAO.update(r);
	}

	@Override
	public List<Resume> list() {
		return this.resumeDAO.list();
	}

	@Override
	public Resume getById(int id) {
		return this.resumeDAO.getById(id);
	}

	@Override
	public void remove(int id) {
		this.resumeDAO.remove(id);
	}
	
	@Override
	public void updateByNameAndObject(String name,Resume r){
		this.resumeDAO.updateByNameAndObject(name,r);
	}
}
