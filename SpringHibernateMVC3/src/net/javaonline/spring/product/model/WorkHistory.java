package net.javaonline.spring.product.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/*, uniqueConstraints = {@UniqueConstraint(columnNames = { "a", "b" }) }*/
@Entity
@Table(name="work_history" )                          
public class WorkHistory implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Column(name="last_reward")
	private String lastreward;
	@Column(name="work_field")
	private String workfield;

	
	
	@Id
	@Column(name="start_date")
	private String startdate;
	@Id
	@Column(name="finish_date")
	private String finishdate;
	@Id
	@Column(name="department_name")
	private String departmentname;
	
	@Id
	@ManyToOne(optional = false)
	@JoinColumns(value = {
	          @JoinColumn(name = "resume_id", referencedColumnName = "id")})
	private Resume resume;

	public WorkHistory() {
		super();
	}
	
	

	public WorkHistory(String lastreward, String workfield, String startdate, String finishdate,
			String departmentname) {
		super();
		this.lastreward = lastreward;
		this.workfield = workfield;
		this.startdate = startdate;
		this.finishdate = finishdate;
		this.departmentname = departmentname;
	}



	public String getLastreward() {
		return lastreward;
	}



	public void setLastreward(String lastreward) {
		this.lastreward = lastreward;
	}



	public String getWorkfield() {
		return workfield;
	}



	public void setWorkfield(String workfield) {
		this.workfield = workfield;
	}



	public String getStartdate() {
		return startdate;
	}



	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}



	public String getFinishdate() {
		return finishdate;
	}



	public void setFinishdate(String finishdate) {
		this.finishdate = finishdate;
	}



	public String getDepartmentname() {
		return departmentname;
	}



	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}



	public Resume getResume() {
		return resume;
	}



	public void setResume(Resume resume) {
		this.resume = resume;
	}
	
	
}