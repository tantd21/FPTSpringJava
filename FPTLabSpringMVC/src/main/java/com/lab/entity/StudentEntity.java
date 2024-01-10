package com.lab.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "tbl_student")
public class StudentEntity extends BaseEnity{
	@Id 
	@Column (name= "student_id_card", columnDefinition = "int(30)")
	    private Long studentIdCard;
	
	@Column (name= "student_name", columnDefinition = "varchar(255)")
	    private String studentName;
	
	@Column (name= "student_email", columnDefinition = "varchar(255)")
	    private String studentEmail;
	
	@Column (name= "student_phone", columnDefinition = "varchar(255)")
	    private String studentPhone;
	
	@Column (name= "student_adress", columnDefinition = "varchar(255)")
	    private String studentAddress;
	
	@OneToMany(mappedBy = "student")
	private List<WorkEntity> workList = new ArrayList<>();
	
	@OneToMany(mappedBy = "student")
	private List<GraduateEntity> graduateList = new ArrayList<>();


	    public StudentEntity() {
	        // Default constructor
	    }

	    public StudentEntity(Long studentIdCard, String studentName, String studentEmail, String studentPhone, String studentAddress) {
	        this.studentIdCard = studentIdCard;
	        this.studentName = studentName;
	        this.studentEmail = studentEmail;
	        this.studentPhone = studentPhone;
	        this.studentAddress = studentAddress;
	    }

	    // Getters and setters for each field

	    public Long getStudentIdCard() {
	        return studentIdCard;
	    }

	    public void setStudentIdCard(Long studentIdCard) {
	        this.studentIdCard = studentIdCard;
	    }

	    public String getStudentName() {
	        return studentName;
	    }

	    public void setStudentName(String studentName) {
	        this.studentName = studentName;
	    }

	    public String getStudentEmail() {
	        return studentEmail;
	    }

	    public void setStudentEmail(String studentEmail) {
	        this.studentEmail = studentEmail;
	    }

	    public String getStudentPhone() {
	        return studentPhone;
	    }

	    public void setStudentPhone(String studentPhone) {
	        this.studentPhone = studentPhone;
	    }

	    public String getStudentAddress() {
	        return studentAddress;
	    }

	    public void setStudentAddress(String studentAddress) {
	        this.studentAddress = studentAddress;
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
