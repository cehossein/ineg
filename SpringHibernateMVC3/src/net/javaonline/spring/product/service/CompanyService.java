package net.javaonline.spring.product.service;

import java.util.List;

import net.javaonline.spring.product.model.Company;

public interface CompanyService {

	void add(Company company, int resume_id);

	void add(Company r);

	void update(Company r);

	List<Company> list();

	Company getById(int id);

	void remove(int id);

	void updateByNameAndObject(String name, Company r);
	

}
