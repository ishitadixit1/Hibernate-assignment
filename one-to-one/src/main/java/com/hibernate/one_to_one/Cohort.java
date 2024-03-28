package com.hibernate.one_to_one;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Cohort {
	
	@Id
	@Column(name="cohort_id")
	private int cohortId;
	private String cohortName;
	
	@OneToOne(mappedBy = "cohort")
	private Project p;
	
	public Cohort(int cohortId, String cohortName, Project p) {
		super();
		this.cohortId = cohortId;
		this.cohortName = cohortName;
		this.p = p;
	}

	public Cohort() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Project getP() {
		return p;
	}

	public void setP(Project p) {
		this.p = p;
	}

	public int getCohortId() {
		return cohortId;
	}
	public void setCohortId(int cohortId) {
		this.cohortId = cohortId;
	}
	public String getCohortName() {
		return cohortName;
	}
	public void setCohortName(String cohortName) {
		this.cohortName = cohortName;
	}
	
}
