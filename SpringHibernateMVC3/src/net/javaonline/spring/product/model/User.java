package net.javaonline.spring.product.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user") /*<-- baiad in esm moadele hamon chizi bashe ke dar
public ModelAndView executeLogin(@ModelAttribute("user") User user) estefade shode
bashad . ya'ni                                            __  in User 
*/public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="username" , unique = true)
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="type")
	private String type;
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	
	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="resume_id")
    private Resume resume;

	public User() {
		super();
	}

	public User(String username, String password, String type) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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