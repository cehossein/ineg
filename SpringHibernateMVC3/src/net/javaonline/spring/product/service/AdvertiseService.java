package net.javaonline.spring.product.service;

import java.util.List;

import net.javaonline.spring.product.model.Advertise;

public interface AdvertiseService {
	
	public void add(Advertise c);
	public void add(Advertise c,int resume_id);
	public void update(Advertise c);
	public List<Advertise> list(int resume_id);   
	//public List<Resume> list(String skill_name);
	public Advertise getById(int skill_id,int resume_id);
	public void remove(int skill_id,int resume_id);
	//public void updateByNameAndObject(String name,WorkHistory c);
	public void add(Advertise advertise, int resume_id, int contactDescrptionId);
}
