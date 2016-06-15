package net.javaonline.spring.product.dao;

import java.util.List;

import net.javaonline.spring.product.model.ContactDescription;
import net.javaonline.spring.product.model.IndividualDescription;

public interface ContactDescriptionDAO {

	public void add(ContactDescription i);
	public void update(ContactDescription i);
	public List<ContactDescription> list();   ///
	public ContactDescription getById(int id);
	public void remove(int id);
	public void updateByIdAndObject(int resume_id,ContactDescription c);
	/*public void save(ContactDescription i);
	public List<ContactDescription> list();       ///
*/
	public int search(ContactDescription contactDescription);	
}
