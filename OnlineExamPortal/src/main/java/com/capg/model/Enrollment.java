package com.capg.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="testenroll")
public class Enrollment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="test_id")
	@JsonBackReference
	private test test;
	
	@Column(name="Course_Name",length=20)
	private String courseType;

	@Column(name="Status",length=3)
	private String statusCheck;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer testid) {
		this.id = testid;
	}

	public test getTest() {
		return test;
	}

	public void setTest(test test) {
		this.test = test;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getStatusCheck() {
		return statusCheck;
	}

	public void setStatusCheck(String statusCheck) {
		this.statusCheck = statusCheck;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Enrollment [id=" + id + ", test=" + test + ", courseType=" + courseType + ", statusCheck=" + statusCheck
				+ ", user=" + user + "]";
	}


}
