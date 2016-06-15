package net.javaonline.spring.product.service;

import java.util.List;

import net.javaonline.spring.product.model.ContactDescription;
import net.javaonline.spring.product.model.IndividualDescription;

public interface ContactDescriptionService {

	public void add(ContactDescription c);
	public void update(ContactDescription c);
	public List<ContactDescription> list();   
	public ContactDescription getById(int id);
	public void remove(int id);
	public void updateByIdAndObject(int resume_id,ContactDescription c);
	public int search(ContactDescription contactDescription);
}
