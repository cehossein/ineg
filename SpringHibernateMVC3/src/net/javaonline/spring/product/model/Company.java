package net.javaonline.spring.product.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "company")
public class Company implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="name")
	private String name;
	
	@Column(name="www")
	private String www;
	
	@Column(name="address")
	private String address;

	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
	@OneToOne
    @JoinColumn(name="resume_id")
    private Resume resume;

	
	public Company() {
		super();
	}


	public Company(String name, String www, String address) {
		super();
		this.name = name;
		this.www = www;
		this.address = address;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getWww() {
		return www;
	}


	public void setWww(String www) {
		this.www = www;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Resume getResume() {
		return resume;
	}


	public void setResume(Resume resume) {
		this.resume = resume;
	}
	
}