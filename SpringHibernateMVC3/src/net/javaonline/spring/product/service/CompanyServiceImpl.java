package net.javaonline.spring.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaonline.spring.product.dao.CompanyDAO;
import net.javaonline.spring.product.model.Company;

@Transactional
@Service
public class CompanyServiceImpl implements CompanyService {
	
	private CompanyDAO companyDAO;
	
	public void setCompanyDAO(CompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}
	
	@Override
	public void add(Company r) {
		this.companyDAO.add(r);
	}

	@Override
	public void update(Company r) {
		this.companyDAO.update(r);
	}

	@Override
	public List<Company> list() {
		return this.companyDAO.list();
	}

	@Override
	public Company getById(int id) {
		return this.companyDAO.getById(id);
	}

	@Override
	public void remove(int id) {
		this.companyDAO.remove(id);
	}
	
	@Override
	public void updateByNameAndObject(String name,Company r){
		this.companyDAO.updateByNameAndObject(name,r);
	}

	@Override
	public void add(Company company, int resume_id) {
		this.companyDAO.add(company,resume_id);
		
	}
}
