package net.javaonline.spring.product.dao;

import java.util.List;

import net.javaonline.spring.product.model.Advertise;


public interface AdvertiseDAO {

	public void update(Advertise r);
/*	public List<Resume> listResume();*/	
	
	@SuppressWarnings("unchecked")
	public Advertise getById(int skill_id , int resume_id);//
	
	public void remove(int skill_id , int resume_id);
/*	public void save(Resume r);
*/	public List<Advertise> list(int resume_id);       ///
	//public void updateByIdAndObject(int name,Skill r);
	void add(Advertise p);
	void add(Advertise p, int resume_id);
	/*List<Advertise> list(String skill_name);*/

	public void add(Advertise advertise, int resume_id, int contactDescrptionId);
}
