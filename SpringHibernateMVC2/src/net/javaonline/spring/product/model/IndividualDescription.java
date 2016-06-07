package net.javaonline.spring.product.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*This page is ok*/
@Entity
@Table(name="individual_description")
public class IndividualDescription implements Serializable{


	public IndividualDescription() {
		super();
	}

	public IndividualDescription(String name, String lastname, String marriagestatus, String sex, String email) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.marriagestatus = marriagestatus;
		this.sex = sex;
		this.email = email;
	}

	private static final long serialVersionUID = 1L;
	
	@Column(name="name")
	private String name;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="marriagestatus")
	private String marriagestatus;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="email")
	private String email;
	
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

/*    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMarriagestatus() {
		return marriagestatus;
	}

	public void setMarriagestatus(String marriagestatus) {
		this.marriagestatus = marriagestatus;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

/*	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}*/
  
}