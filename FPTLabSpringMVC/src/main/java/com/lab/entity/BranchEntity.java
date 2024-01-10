package com.lab.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_branch")
public class BranchEntity extends BaseEnity{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column (name= "branch_id", columnDefinition = "int(10)")
	int branchId;
	
	@Column (name= "branch_name", columnDefinition = "varchar(255)")
	String branchName;
	
	@Column (name= "branch_type", columnDefinition = "varchar(255)")
	String branchType;
	
	@OneToMany(mappedBy = "branch")
	private List<WorkEntity> workList = new ArrayList<>();
	
	@OneToMany(mappedBy = "branch")
	private List<GraduateEntity> graduateList = new ArrayList<>();
	
	public BranchEntity() {}

	public BranchEntity(int branchId, String branchName, String branchType) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.branchType = branchType;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchType() {
		return branchType;
	}

	public void setBranchType(String branchType) {
		this.branchType = branchType;
	}

	public List<WorkEntity> getWork() {
		return workList;
	}

	public void setWork(List<WorkEntity> work) {
		this.workList = work;
	}

	public List<WorkEntity> getWorkList() {
		return workList;
	}

	public void setWorkList(List<WorkEntity> workList) {
		this.workList = workList;
	}

	public List<GraduateEntity> getGraduateList() {
		return graduateList;
	}

	public void setGraduateList(List<GraduateEntity> graduateList) {
		this.graduateList = graduateList;
	}

	
	
	
}
