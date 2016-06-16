package net.javaonline.spring.product.service;

import java.util.List;

import net.javaonline.spring.product.model.Advertise;
import net.javaonline.spring.product.model.SkillAdvertise;

public interface SkillAdvertiseService {
	
	public void add(SkillAdvertise c);
	public void add(SkillAdvertise c,int advertise_id);
	public void update(SkillAdvertise c);
	public List<SkillAdvertise> list(int advertise_id);   
	public List<Advertise> list(String skill_name);
	public SkillAdvertise getById(int skill_id,int advertise_id);
	public void remove(int skill_id,int advertise_id);
	//public void updateByNameAndObject(String name,WorkHistory c);
}
