package net.javaonline.spring.product.dao;

import java.util.List;

import net.javaonline.spring.product.model.Advertise;
import net.javaonline.spring.product.model.SkillAdvertise;;


public interface SkillAdvertiseDAO {

	public void update(SkillAdvertise r);
/*	public List<Resume> listResume();   ///
*/	public SkillAdvertise getById(int skill_id , int advertise_id);
	public void remove(int skill_id , int advertise_id);
/*	public void save(Resume r);
*/	public List<SkillAdvertise> list(int advertise_id);       ///
	//public void updateByIdAndObject(int name,Skill r);
	void add(SkillAdvertise p);
	void add(SkillAdvertise p, int advertise_id);
	List<Advertise> list(String skill_name);
}
