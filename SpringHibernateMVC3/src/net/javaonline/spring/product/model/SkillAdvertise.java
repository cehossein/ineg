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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table; 

@Entity
@Table(name="skill_adv") 
public class SkillAdvertise implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
	@Column(name="name")
	private String name;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne(optional = false)
	@JoinColumns(value = {
	          @JoinColumn(name = "advertise_id", referencedColumnName = "id")})
	private Advertise advertise;

	public SkillAdvertise() {
		super();
	}

	public SkillAdvertise(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Advertise getAdvertise() {
		return advertise;
	}

	public void setAdvertise(Advertise advertise) {
		this.advertise = advertise;
	}
}