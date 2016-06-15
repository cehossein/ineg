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
@Table(name = "advertise")
public class Advertise implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="propagate_date")
	private String PropagateDate;
	
	@Column(name="co_name")
	private String CoName;
	
	@Column(name="wage")
	private String wage;

	@Column(name="adv_text")
	private String AdvText;
	
	@Column(name="title")
	private String Title;

	@Column(name="city_name")
	private String CityName;
	
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	
    @ManyToOne(optional = false)
    @JoinColumn(name ="cont_id")
    private ContactDescription contactDescription;


    @ManyToOne(optional = false)
    @JoinColumn(name ="resume_id")
    private Resume resume;
    
    
	public Advertise() {
		super();
	}


	public Advertise(String propagateDate, String coName, String wage, String advText, String title, String cityName) {
		super();
		PropagateDate = propagateDate;
		CoName = coName;
		this.wage = wage;
		AdvText = advText;
		Title = title;
		CityName = cityName;
	}


	public String getPropagateDate() {
		return PropagateDate;
	}


	public void setPropagateDate(String propagateDate) {
		PropagateDate = propagateDate;
	}


	public String getCoName() {
		return CoName;
	}


	public void setCoName(String coName) {
		CoName = coName;
	}


	public String getWage() {
		return wage;
	}


	public void setWage(String wage) {
		this.wage = wage;
	}


	public String getAdvText() {
		return AdvText;
	}


	public void setAdvText(String advText) {
		AdvText = advText;
	}


	public String getTitle() {
		return Title;
	}


	public void setTitle(String title) {
		Title = title;
	}


	public String getCityName() {
		return CityName;
	}


	public void setCityName(String cityName) {
		CityName = cityName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public ContactDescription getContactDescription() {
		return contactDescription;
	}


	public void setContactDescription(ContactDescription contactDescription) {
		this.contactDescription = contactDescription;
	}


	public Resume getResume() {
		return resume;
	}


	public void setResume(Resume resume) {
		this.resume = resume;
	}

}