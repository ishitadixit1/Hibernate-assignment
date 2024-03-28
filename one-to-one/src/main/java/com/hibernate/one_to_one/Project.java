package com.hibernate.one_to_one;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Project {
	
	@Id
	@Column(name="project_id")
	private int projectId;
	
	private String projectName;
	
	@OneToOne
	@JoinColumn(name="cohort_id")
	private Cohort cohort;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int projectId, String projectName, Cohort cohort) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.cohort = cohort;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Cohort getCohort() {
		return cohort;
	}

	public void setCohort(Cohort cohort) {
		this.cohort = cohort;
	}
	
	
	

}
