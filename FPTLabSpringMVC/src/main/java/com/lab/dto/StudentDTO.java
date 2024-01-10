package com.lab.dto;

import java.util.ArrayList;
import java.util.List;

import com.lab.entity.GraduateEntity;
import com.lab.entity.WorkEntity;

public class StudentDTO extends AbstractDTO<StudentDTO>{
	    private Long studentIdCard;
	    private String studentName;
	    private String studentEmail;
	    private String studentPhone;
	    private String studentAddress;
	    private List<WorkEntity> workList = new ArrayList<>();
	    private List<GraduateEntity> graduateList = new ArrayList<>();

	    // Constructors, getters, setters

	    public StudentDTO() {
	        // Default constructor
	    }

	    public StudentDTO(Long studentIdCard, String studentName, String studentEmail, String studentPhone, String studentAddress) {
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
