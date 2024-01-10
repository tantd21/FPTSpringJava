package com.lab.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;

import com.lab.entity.GraduateEntity;
import com.lab.entity.WorkEntity;

public class BranchDTO extends AbstractDTO<BranchDTO>{
	int branchId;
	String branchName;
	String branchType;
	private List<WorkEntity> workList = new ArrayList<>();
	private List<GraduateEntity> graduateList = new ArrayList<>();
	
	public BranchDTO() {};
	
	public BranchDTO(int branchId, String branchName, String branchType) {
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

	public void setWork(List<WorkEntity> workList) {
		this.workList = workList;
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
