package com.lab.dto;

import java.util.ArrayList;
import java.util.List;

import com.lab.entity.GraduateEntity;
import com.lab.entity.WorkEntity;

public class SchoolDTO extends AbstractDTO<SchoolDTO> {
	int schoolId;
	String schoolName;
	String schoolAddress;
	String schoolPhone;
	
	private List<GraduateEntity> graduateList = new ArrayList<>();
	
	public SchoolDTO() {}
	
	public SchoolDTO(int schoolId, String schoolName, String schoolAddress, String schoolPhone) {
		super();
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.schoolAddress = schoolAddress;
		this.schoolPhone = schoolPhone;
	}
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolAddress() {
		return schoolAddress;
	}
	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}
	public String getSchoolPhone() {
		return schoolPhone;
	}
	public void setSchoolPhone(String schoolPhone) {
		this.schoolPhone = schoolPhone;
	}

	public List<GraduateEntity> getGraduateList() {
		return graduateList;
	}

	public void setGraduateList(List<GraduateEntity> graduateList) {
		this.graduateList = graduateList;
	}

	
	
	
	
}
