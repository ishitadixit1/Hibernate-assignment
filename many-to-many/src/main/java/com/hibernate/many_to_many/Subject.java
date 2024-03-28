package com.hibernate.many_to_many;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Subject {

	@Id
	@Column(name="sub_code")
	private int subjectCode;
	private String subjectName;
	
	@ManyToMany
	private List<Professor> prof;
	

	public Subject() {
		super();
	}

	public int getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public List<Professor> getProf() {
		return prof;
	}

	public void setProf(List<Professor> prof) {
		this.prof = prof;
	}
	
	
}
