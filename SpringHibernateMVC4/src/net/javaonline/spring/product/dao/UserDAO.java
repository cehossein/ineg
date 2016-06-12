package net.javaonline.spring.product.dao;

import java.util.List;

import net.javaonline.spring.product.model.User;

public interface UserDAO {

	public void add(User u);
	public void update(User u);
	public List<User> list();   ///
	public User getById(int id);
	public void remove(int id);
	public User getUserByUserName(String username);
	
/*	public void save(User u);
	public List<User> list();       ///
*/	
}
