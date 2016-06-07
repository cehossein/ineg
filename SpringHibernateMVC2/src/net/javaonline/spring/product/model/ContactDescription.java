package net.javaonline.spring.product.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*This page is ok*/
@Entity
@Table(name="contact_description")
public class ContactDescription implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="phone")
	private String phone;
	@Column(name="email")
	private String email;
	@Column(name="address")
	private String address;
	
	
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    
	@OneToMany(mappedBy="contactDescription" , cascade = CascadeType.ALL)
	private List<Resume> resumes;
	
	public ContactDescription() {
		super();
	}

	public ContactDescription(String phone, String email, String address) {
		super();
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Resume> getResumes() {
		return resumes;
	}

	public void setResumes(List<Resume> resumes) {
		this.resumes = resumes;
	}
	


}