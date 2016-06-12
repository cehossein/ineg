package net.javaonline.spring.product.dao;

import java.util.List;

import net.javaonline.spring.product.model.IndividualDescription;
import net.javaonline.spring.product.model.Resume;

public interface ResumeDAO {

	public void add(Resume r);
	public void update(Resume r);
/*	public List<Resume> listResume();   ///
*/	public Resume getById(int id);
	public void remove(int id);
/*	public void save(Resume r);
*/	public List<Resume> list();       ///
	public void updateByNameAndObject(String name,Resume r);
}
