package net.javaonline.spring.product.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaonline.spring.product.dao.UserDAO;
import net.javaonline.spring.product.model.IndividualDescription;
import net.javaonline.spring.product.model.User;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	
	
	private UserDAO userDAO;
	
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public void add(User u) {
		this.userDAO.add(u);
	}

	@Override
	public void update(User u) {
		this.userDAO.update(u);
	}

	@Override
	public List<User> list() {
		return this.userDAO.list();
	}

	@Override
	public User getById(int id) {
		return this.userDAO.getById(id);
	}

	@Override
	public void remove(int id) {
		this.userDAO.remove(id);
	}
	
	@Override
	public User getUserByUserName(String username) {
		return this.userDAO.getUserByUserName(username);
	}
}
