package net.javaonline.spring.product.service;

import java.util.List;

import net.javaonline.spring.product.model.Resume;

public interface ResumeService {

	public void add(Resume r);
	public void update(Resume r);
	public List<Resume> list();   
	public Resume getById(int id);
	public void remove(int id);
	public void updateByNameAndObject(String name,Resume r);

}
