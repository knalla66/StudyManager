package at.fh.swenga.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Professors")
public class ProfessorModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String firstname;

	@Column(nullable = false)
	private String lastname;

	@Column
	private String mail = firstname + "." + lastname + "@studymanager.com";

	@ManyToMany(mappedBy = "professors") // professors collection is mapped wit the course collection
	private Set<CourseModel> courses = new HashSet<CourseModel>();
	public Set<CourseModel> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseModel> courses) {
		this.courses = courses;
	}

	public ProfessorModel(String firstname, String lastname, String mail) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.mail = mail;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}