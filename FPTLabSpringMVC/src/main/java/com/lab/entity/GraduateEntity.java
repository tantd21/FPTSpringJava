package com.lab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lab.dto.StudentDTO;

@Entity
@Table(name = "tbl_graduate")
public class GraduateEntity extends BaseEnity{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column (name= "graduate_id", columnDefinition = "int(10)")
		private int graduateId;
	
	@Column (name= "graduate_program", columnDefinition = "varchar(255)")
	    private String graduateProgram;
	
	@Column (name= "graduate_date", columnDefinition = "varchar(255)")
	    private String graduateDate;
	
	@Column (name= "graduate_type", columnDefinition = "varchar(255)")
	    private String graduateType;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    private BranchEntity branch;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id")
    private SchoolEntity school;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id_card")
    private StudentEntity student;
	


	    public GraduateEntity() {
	        // Default constructor
	    }

	    public GraduateEntity(int graduateId, int studentIdCard, int schoolId, int branchId, String graduateProgram,
	                    String graduateDate, String graduateType) {
	        this.graduateId = graduateId;
	        this.graduateProgram = graduateProgram;
	        this.graduateDate = graduateDate;
	        this.graduateType = graduateType;
	    }

	    // Getters and setters for each field

	    public int getGraduateId() {
	        return graduateId;
	    }

	    public void setGraduateId(int graduateId) {
	        this.graduateId = graduateId;
	    }


	    public String getGraduateProgram() {
	        return graduateProgram;
	    }

	    public void setGraduateProgram(String graduateProgram) {
	        this.graduateProgram = graduateProgram;
	    }

	    public String getGraduateDate() {
	        return graduateDate;
	    }

	    public void setGraduateDate(String graduateDate) {
	        this.graduateDate = graduateDate;
	    }

	    public String getGraduateType() {
	        return graduateType;
	    }

	    public void setGraduateType(String graduateType) {
	        this.graduateType = graduateType;
	    }

		public BranchEntity getBranch() {
			return branch;
		}

		public void setBranch(BranchEntity branch) {
			this.branch = branch;
		}

		public SchoolEntity getSchool() {
			return school;
		}

		public void setSchool(SchoolEntity school) {
			this.school = school;
		}

		public StudentEntity getStudent() {
			return student;
		}

		public void setStudent(StudentEntity student) {
			this.student = student;
		}
	    

}
