package net.javaonline.spring.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaonline.spring.product.dao.IndividualDescriptionDAO;
import net.javaonline.spring.product.model.IndividualDescription;
import net.javaonline.spring.product.model.User;

@Transactional
@Service
public class IndividualDescriptionServiceImpl implements IndividualDescriptionService {
	
	private IndividualDescriptionDAO individualDescriptionDAO;
	
	public void setIndividualDescriptionDAO(IndividualDescriptionDAO individualDescriptionDAO) {
		this.individualDescriptionDAO = individualDescriptionDAO;
	}
	
	@Override
	public void add(IndividualDescription i) {
		this.individualDescriptionDAO.add(i);
	}

	@Override
	public void update(IndividualDescription i) {
		this.individualDescriptionDAO.update(i);
	}

	@Override
	public List<IndividualDescription> list() {
		return this.individualDescriptionDAO.list();
	}

	@Override
	public IndividualDescription getById(int id) {
		return this.individualDescriptionDAO.getById(id);
	}

	@Override
	public void remove(int id) {
		this.individualDescriptionDAO.remove(id);
	}

	@Override
	public void updateByIdAndObject(int id,IndividualDescription i){
		this.individualDescriptionDAO.updateByIdAndObject(id,i);
	}
}
