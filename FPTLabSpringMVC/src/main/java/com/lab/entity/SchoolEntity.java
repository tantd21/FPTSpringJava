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
@Table(name = "tbl_school")
public class SchoolEntity extends BaseEnity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column (name= "school_id", columnDefinition = "int(10)")
	int schoolId;
	
	@Column (name= "school_name", columnDefinition = "varchar(255)")
	String schoolName;
	
	@Column (name= "school_address", columnDefinition = "varchar(255)")
	String schoolAddress;
	
	@Column (name= "school_phone", columnDefinition = "varchar(255)")
	String schoolPhone;
	
	@OneToMany(mappedBy = "school")
	private List<GraduateEntity> graduateList = new ArrayList<>();
	
	public SchoolEntity() {
		
	}
	

	public SchoolEntity(int schoolId, String schoolName, String schoolAddress, String schoolPhone) {
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
