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

/*This page is ok*/
@Entity
@Table(name = "resume")
public class Resume implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="favoritycity")
	private String favoritycity;
	
	@Column(name="favorityjob")
	private String favorityjob;
	
	@Column(name="requestedwage")
	private String requestedwage;

	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
    @OneToOne
    @JoinColumn(name="indi_id")
    private IndividualDescription individualDescription;

    @ManyToOne(optional = false)
    @JoinColumn(name ="cont_id")
    private ContactDescription contactDescription;


	public Resume() {
		super();
	}

	public Resume(String favoritycity, String favorityjob, String requestedwage) {
		super();
		this.favoritycity = favoritycity;
		this.favorityjob = favorityjob;
		this.requestedwage = requestedwage;
	}

	public String getFavoritycity() {
		return favoritycity;
	}

	public void setFavoritycity(String favoritycity) {
		this.favoritycity = favoritycity;
	}

	public String getFavorityjob() {
		return favorityjob;
	}

	public void setFavorityjob(String favorityjob) {
		this.favorityjob = favorityjob;
	}

	public String getRequestedwage() {
		return requestedwage;
	}

	public void setRequestedwage(String requestedwage) {
		this.requestedwage = requestedwage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public IndividualDescription getIndividualDescription() {
		return individualDescription;
	}

	public void setIndividualDescription(IndividualDescription individualDescription) {
		this.individualDescription = individualDescription;
	}

	public ContactDescription getContactDescription() {
		return contactDescription;
	}

	public void setContactDescription(ContactDescription contactDescription) {
		this.contactDescription = contactDescription;
	}

}