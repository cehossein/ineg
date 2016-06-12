package net.javaonline.spring.product.service;

import java.util.List;

import net.javaonline.spring.product.model.IndividualDescription;

public interface IndividualDescriptionService {

	public void add(IndividualDescription i);
	public void update(IndividualDescription i);
	public List<IndividualDescription> list();   
	public IndividualDescription getById(int id);
	public void remove(int id);
	public void updateByIdAndObject(int id,IndividualDescription i);
}
