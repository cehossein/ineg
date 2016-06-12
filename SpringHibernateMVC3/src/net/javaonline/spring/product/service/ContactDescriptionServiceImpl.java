package net.javaonline.spring.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaonline.spring.product.dao.ContactDescriptionDAO;
import net.javaonline.spring.product.model.ContactDescription;
import net.javaonline.spring.product.model.IndividualDescription;

@Transactional
@Service
public class ContactDescriptionServiceImpl implements ContactDescriptionService {
	
	private ContactDescriptionDAO contactDescriptionDAO;
	
	public void setContactDescriptionDAO(ContactDescriptionDAO contactDescriptionDAO) {
		this.contactDescriptionDAO = contactDescriptionDAO;
	}
	
	@Override
	public void add(ContactDescription c) {
		this.contactDescriptionDAO.add(c);
	}

	@Override
	public void update(ContactDescription c) {
		this.contactDescriptionDAO.update(c);
	}

	@Override
	public List<ContactDescription> list() {
		return this.contactDescriptionDAO.list();
	}

	@Override
	public ContactDescription getById(int id) {
		return this.contactDescriptionDAO.getById(id);
	}

	@Override
	public void remove(int id) {
		this.contactDescriptionDAO.remove(id);
	}
	
	@Override
	public void updateByIdAndObject(int resume_id,ContactDescription c){
		this.contactDescriptionDAO.updateByIdAndObject(resume_id,c);
	}
}
