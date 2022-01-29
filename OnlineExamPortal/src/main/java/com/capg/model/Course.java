package com.capg.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="courseid",length = 200)
	private int courseId;
	
	@Column(name="course_type",length=200,unique=true)
	private String courseType;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="course")
	private test test;

	@OneToMany(mappedBy = "course",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Question> question;

	public Course() {

	}

	public Course(String course_type ) {
		this.courseType = course_type;
	}

	public Set<Question> getQuestion() {
		return question;
	}

	public void setQuestion(Set<Question> question) {
		this.question = question;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public test getTest() {
		return test;
	}

	public void setTest(test test) {
		this.test = test;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseType=" + courseType + ", test=" + test + "]";
	}

}
