package net.javaonline.spring.product.dao;

import java.util.List;
import java.util.Set;

import net.javaonline.spring.product.model.Skill;


public interface SkillDAO {

	public void update(Skill r);
/*	public List<Resume> listResume();   ///
*/	public Skill getById(int skill_id , int resume_id);
	public void remove(int skill_id , int resume_id);
/*	public void save(Resume r);
*/	public List<Skill> list(int resume_id);       ///
	//public void updateByIdAndObject(int name,Skill r);
	void add(Skill p);
	void add(Skill p, int resume_id);
}
