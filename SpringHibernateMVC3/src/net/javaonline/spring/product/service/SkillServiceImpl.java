package net.javaonline.spring.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaonline.spring.product.dao.SkillDAO;
import net.javaonline.spring.product.model.Skill;

@Transactional
@Service
public class SkillServiceImpl implements SkillService {
	
	private SkillDAO skillDAO;
	
	public void setSkillDAO(SkillDAO skillDAO) {
		this.skillDAO = skillDAO;
	}
	
	@Override
	public void add(Skill c) {
		this.skillDAO.add(c);
	}
	
	@Override
	public void add(Skill c,int resume_id) {
		this.skillDAO.add(c,resume_id);
	}

	@Override
	public void update(Skill c) {
		this.skillDAO.update(c);
	}

	@Override
	public List<Skill> list(int resume_id) {
		return this.skillDAO.list(resume_id);
	}

	@Override
	public Skill getById(int skill_id,int resume_id) {
		return this.skillDAO.getById(skill_id,resume_id);
	}

	@Override
	public void remove(int skill_id,int resume_id) {
		this.skillDAO.remove(skill_id,resume_id);
	}
	
/*	@Override
	public void updateByNameAndObject(String name,WorkHistory c){
		this.workHistoryDAO.updateByNameAndObject(name,c);
	}*/
}
