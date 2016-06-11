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
@Table(name="educational_history" )                          
public class EducationalHistory implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Column(name="university_name")
	private String universityname;
	@Column(name="start_date")
	private String startdate;
	@Column(name="finish_date")
	private String finishdate;
	@Column(name="average")
	private String average;

	
	
	@Id
	@Column(name="study_field")
	private String studyfield;
	@Id
	@Column(name="grade")
	private String grade;
	@Id
	@Column(name="academic_orientation")
	private String academicorientation;
	
	@Id
	@ManyToOne(optional = false)
	@JoinColumns(value = {
	          @JoinColumn(name = "resume_id", referencedColumnName = "id")})
	private Resume resume;

	public EducationalHistory() {
		super();
	}

	public EducationalHistory(String universityname, String startdate, String finishdate, String average,
			String studyfield, String grade, String academicorientation) {
		super();
		this.universityname = universityname;
		this.startdate = startdate;
		this.finishdate = finishdate;
		this.average = average;
		this.studyfield = studyfield;
		this.grade = grade;
		this.academicorientation = academicorientation;
	}

	public String getUniversityname() {
		return universityname;
	}

	public void setUniversityname(String universityname) {
		this.universityname = universityname;
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

	public String getAverage() {
		return average;
	}

	public void setAverage(String average) {
		this.average = average;
	}

	public String getStudyfield() {
		return studyfield;
	}

	public void setStudyfield(String studyfield) {
		this.studyfield = studyfield;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getAcademicorientation() {
		return academicorientation;
	}

	public void setAcademicorientation(String academicorientation) {
		this.academicorientation = academicorientation;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}
		
}