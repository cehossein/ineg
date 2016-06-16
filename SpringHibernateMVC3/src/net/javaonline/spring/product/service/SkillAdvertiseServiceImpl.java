package net.javaonline.spring.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaonline.spring.product.dao.SkillAdvertiseDAO;
import net.javaonline.spring.product.model.Advertise;
import net.javaonline.spring.product.model.SkillAdvertise;

@Transactional
@Service
public class SkillAdvertiseServiceImpl implements SkillAdvertiseService {
	
	private SkillAdvertiseDAO skillAdvertiseDAO;
	
	public void setSkillAdvertiseDAO(SkillAdvertiseDAO skillAdvertiseDAO) {
		this.skillAdvertiseDAO = skillAdvertiseDAO;
	}
	
	@Override
	public void add(SkillAdvertise c) {
		this.skillAdvertiseDAO.add(c);
	}
	
	@Override
	public void add(SkillAdvertise c,int advertise_id) {
		this.skillAdvertiseDAO.add(c,advertise_id);
	}

	@Override
	public void update(SkillAdvertise c) {
		this.skillAdvertiseDAO.update(c);
	}

	@Override
	public List<SkillAdvertise> list(int advertise_id) {
		return this.skillAdvertiseDAO.list(advertise_id);
	}
	
	@Override
	public List<Advertise> list(String skill_name) {
		return this.skillAdvertiseDAO.list(skill_name);
	}

	@Override
	public SkillAdvertise getById(int skill_id,int advertise_id) {
		return this.skillAdvertiseDAO.getById(skill_id,advertise_id);
	}

	@Override
	public void remove(int skill_id,int advertise_id) {
		this.skillAdvertiseDAO.remove(skill_id,advertise_id);
	}


	
/*	@Override
	public void updateByNameAndObject(String name,WorkHistory c){
		this.workHistoryDAO.updateByNameAndObject(name,c);
	}*/
}
