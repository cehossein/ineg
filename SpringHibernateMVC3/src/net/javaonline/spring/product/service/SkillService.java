package net.javaonline.spring.product.service;

import java.util.List;

import net.javaonline.spring.product.model.Resume;
import net.javaonline.spring.product.model.Skill;

public interface SkillService {
	
	public void add(Skill c);
	public void add(Skill c,int resume_id);
	public void update(Skill c);
	public List<Skill> list(int resume_id);   
	public List<Resume> list(String skill_name);
	public Skill getById(int skill_id,int resume_id);
	public void remove(int skill_id,int resume_id);
	//public void updateByNameAndObject(String name,WorkHistory c);
}
