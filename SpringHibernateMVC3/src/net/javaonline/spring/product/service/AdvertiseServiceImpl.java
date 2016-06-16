package net.javaonline.spring.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaonline.spring.product.dao.AdvertiseDAO;
import net.javaonline.spring.product.model.Advertise;

@Transactional
@Service
public class AdvertiseServiceImpl implements AdvertiseService {
	
	private AdvertiseDAO advertiseDAO;
	
	public void setAdvertiseDAO(AdvertiseDAO advertiseDAO) {
		this.advertiseDAO = advertiseDAO;
	}
	
	@Override
	public void add(Advertise c) {
		this.advertiseDAO.add(c);
	}
	
	@Override
	public void add(Advertise c,int resume_id) {
		this.advertiseDAO.add(c,resume_id);
	}

	@Override
	public void update(Advertise c) {
		this.advertiseDAO.update(c);
	}

	@Override
	public List<Advertise> list(int resume_id) {
		return this.advertiseDAO.list(resume_id);
	}
	
/*	@Override
	public List<Advertise> list(String skill_name) {
		return this.advertiseDAO.list(skill_name);
	}
*/
	@Override
	public Advertise getById(int skill_id,int resume_id) {
		return this.advertiseDAO.getById(skill_id,resume_id);
	}

	@Override
	public void remove(int skill_id,int resume_id) {
		this.advertiseDAO.remove(skill_id,resume_id);
	}

	@Override
	public void add(Advertise advertise, int resume_id, int contactDescrptionId) {
		this.advertiseDAO.add(advertise, resume_id , contactDescrptionId);
		
	}

	@Override
	public int search(Advertise advertise) {
		return this.advertiseDAO.search(advertise);
	}


	
/*	@Override
	public void updateByNameAndObject(String name,WorkHistory c){
		this.workHistoryDAO.updateByNameAndObject(name,c);
	}*/
}
